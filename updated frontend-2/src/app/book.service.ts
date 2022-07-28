import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class BookService {

  URL="http://localhost:8080/book";

  constructor(private http:HttpClient) { }

  fnGetAllBooks()
  {
    return this.http.get(this.URL);
  }

  fnGetAllCarts()
  {
    return this.http.get("http://localhost:8080/ACart");
  }


  fnAddbook(book:any)
  {
    return this.http.post(this.URL,book);
  }

  fnFindBookById(id:any)
  {
    return this.http.get(this.URL+"/"+id);
  }

  getOneBookData(id:any){

    return this.http.get('http://localhost:8080/book/'+id);

  }

  fnAddCart(ACart:any){
    return this.http.post('http://localhost:8080/ACart/',ACart);
  }


  deleteCartData(id){
    return this.http.delete('http://localhost:8080/ACart/delete/'+id)
    
  }


  deleteUserData(id){
    return this.http.delete('http://localhost:8080/api/customers/delete/'+id)
    
  }

  updateCartData(id:number,quantity:number){
    return this.http.get("http://localhost:8080/ACart/updateqty?id="+id+"&quantity="+quantity);
  }

}
