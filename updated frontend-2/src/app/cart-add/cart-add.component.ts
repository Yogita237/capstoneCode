import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Books } from '../add-book/book.model';
import { BookService } from '../book.service';

@Component({
  selector: 'app-cart-add',
  templateUrl: './cart-add.component.html',
  styleUrls: ['./cart-add.component.css']
})
export class CartAddComponent implements OnInit {
  id:any;
 books = new Books();
 data:any;
 addtocart:any;
  constructor(
    private route:ActivatedRoute,
    private bookService:BookService,
    private bs:BookService,
    private fb:FormBuilder,
   
    
    ) {
      this.addtocart=this.fb.group({
    
        id:[''],
        name:[''],
        price:[''],
        quantity:[''],
      
        
      });
     }

  ngOnInit(): void {

    this.id=this.route.snapshot.paramMap.get('id');
    this.getOneBookData();

    
  }

  getOneBookData(){
     this.bookService.getOneBookData(this.id).subscribe(res=>{
      this.data=res;
     this.books=this.data;

     })


  }
  
  fnAdd()
  {
    const custid=sessionStorage.getItem('id')
    if(custid!=null){
    
    var ACart=new FormData();
    
    ACart.append('name',this.addtocart.controls.name.value)
    ACart.append('price',this.addtocart.controls.price.value)
    ACart.append('quantity','1')
 

    console.log(ACart);
    
    this.bs.fnAddCart(ACart).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
      
    });
    alert('Added to Cart !!!')
  }
  else
  alert("Please log in first");

  
}



}
