import { Component, OnInit } from '@angular/core';
import {BookService} from '../book.service';
import {BookDisplayService} from '../book-display.service';


@Component({
  selector: 'app-display-book',
  templateUrl: './display-book.component.html',
  styleUrls: ['./display-book.component.css']
})
export class DisplayBookComponent implements OnInit {

  books:any;
  constructor(private bs:BookService){}

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
  
  /*
  fnAddToCart(id:any)
  {
    alert(id);
    var book:any;
    var user:any;
    this.bs.fnFindBookById(id).subscribe((data)=>{
      book=data;

      //take the logged in customer id from localStorage
      var cid=1;
      // cid=localStorage.getItem("cid");
      
      this.us.fnFindUserById(cid).subscribe((data:any)=>{
        user=data;

        var qty=1;

        var cart={"user":user,"book":book,"quantity":qty};
        this.cartS.fnAddToCart(cart).subscribe((data)=>{
          console.log("After adding, we got the following response from add to cart");
          console.log(data);
        });
      });
      
    })
  }*/


  
}
