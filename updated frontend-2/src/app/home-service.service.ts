import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {

  URL="http://localhost:8080/ACart";

  constructor(private http:HttpClient) { }

  fnGetAllBooks()
  {
    return this.http.get(this.URL);
  }

  fnAddCart(book:any)
  {
    return this.http.post(this.URL,book);
  }

  fnFindBookById(id:any)
  {
    return this.http.get(this.URL+"/"+id);
  }
}
