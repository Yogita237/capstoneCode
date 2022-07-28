import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import { ApiService } from '../api.service';
import {BookService} from '../book.service'
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  addBookForm:any;
  selectedFile:any;
  Delete:any;
  list:any[];
  constructor(private fb:FormBuilder, private bs:BookService,private api:ApiService) { 
    this.addBookForm=this.fb.group({
      // id
      names:[''],
      price:[''],
      author:[''],
      genre:[''],
      category:[''],
      picture:[]
      
    });
  }

  ngOnInit(): void {
    this.loadData()
  }

  loadData(){
    this.api.listcustomers().subscribe({
      next:resp=>this.list=resp
    })
  }

  fnChange(event:any)
  {
    this.selectedFile=event.target.files[0];
    console.log(JSON.stringify(this.selectedFile));
  }

  fnAdd()
  {
    
    var book=new FormData();
   
    book.append('names',this.addBookForm.controls.names.value)
    book.append('price',this.addBookForm.controls.price.value)
    book.append('author',this.addBookForm.controls.author.value)
    book.append('genre',this.addBookForm.controls.genre.value)
    book.append('category',this.addBookForm.controls.category.value)
    book.append('picture',this.selectedFile, this.selectedFile.name);

    console.log(book);
    
    this.bs.fnAddbook(book).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
      
    });
    alert('Book Added Successfully!!!')
  }


  delete(p){

   
    console.log(p);
    this.bs.deleteUserData(p).subscribe(data=>
      {
       
   
        this.api.listcustomers().subscribe({
          next:resp=>this.list=resp

        
        })

        alert("User deleted !!!")
  
      })
  }
}
