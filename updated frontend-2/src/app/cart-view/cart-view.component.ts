import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css']
})
export class CartViewComponent implements OnInit {

  books:any;
  address="";
  card="";
  mmyy="";
  cvv="";
  name="";
  constructor(private bs:BookService) { }

  ngOnInit(): void {

    this.bs.fnGetAllCarts().subscribe((data)=>{
      console.log(data);
      this.books=data;
      console.log(this.books);
    },(error)=>{
      console.log(error);
    });
    console.log(this.books);

  }

  delete(p){

    console.log(p);
    this.bs.deleteCartData(p).subscribe(data=>
      {
       
        

          this.bs.fnGetAllCarts().subscribe((data)=>{
            console.log(data);
            this.books=data;
            console.log(this.books);
          },(error)=>{
            console.log(error);
          });
          console.log(this.books);
   
  
      })
  }

  updateqty(id:any,quantity:any){

    console.log(id,quantity);

    this.bs.updateCartData(id,quantity).subscribe(data=>
      {
       
        if(quantity <=0){
            alert("Less than zero is not aloud")
        }else if(quantity > 0){ this.bs.fnGetAllCarts().subscribe((data)=>{
          console.log(data);
          this.books=data;
          console.log(this.books);
        },(error)=>{
          console.log(error);
        });
        console.log(this.books);}
         
   
  
      })
      console.log(id,quantity);
  }

  message(){
    alert("Order are placed.")
    
  }
  


}
