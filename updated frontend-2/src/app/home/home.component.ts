import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ApiService } from '../api.service';
import { HomeServiceService } from '../home-service.service';
import { BookService } from '../book.service';
import {CartAddComponent} from '../cart-add/cart-add.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  addCartForm:any;
  books:any;
  ChangeCategory(e){

    console.log(e.target.value);
  }
  constructor(private bs:BookService,private fb:FormBuilder,private bs2:HomeServiceService){

    this.addCartForm=this.fb.group({
      // id
      name:[''],
      price:['']
    
      
    });
  }

  ngOnInit(): void {
 

    this.bs.fnGetAllBooks().subscribe((data)=>{
      console.log(data);
      this.books=data;
      console.log(this.books);
    },(error)=>{
      console.log(error);
    });
    console.log(this.books);
  }

  fnAdd()
  {
    
    var book=new FormData();
   
    book.append('name',this.addCartForm.controls.name.value)
    book.append('price',this.addCartForm.controls.price.value)
   
    console.log(book);
    
    this.bs2.fnAddCart(book).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
      
    });
    alert('Book Added Successfully!!!')
  }

  

}
