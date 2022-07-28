import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import { ToastrModule } from 'ngx-toastr';
import { NavbarComponent } from './navbar/navbar.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { CategoryComponent } from './category/category.component';
import { ProductsComponent } from './products/products.component';
import { UsersComponent } from './users/users.component';
import { OrdersComponent } from './orders/orders.component';

import { ViewcartComponent } from './viewcart/viewcart.component';

import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { ApiService } from './api.service';
import { ProfileComponent } from './profile/profile.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { FooterComponent } from './footer/footer.component';
import {AddBookComponent} from '../app/add-book/add-book.component';
import { CartAddComponent } from './cart-add/cart-add.component'
import { FormsModule } from '@angular/forms';
import { CartViewComponent } from './cart-view/cart-view.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    HomeComponent,
    CategoryComponent,
    ProductsComponent,
    UsersComponent,
    OrdersComponent,

    ViewcartComponent,
    ProfileComponent,
    OrderhistoryComponent,
    AdminloginComponent,
    FooterComponent,
    AddBookComponent,
    CartAddComponent,
    CartViewComponent,
    AdminLoginComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, 
    HttpClientModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(), 
    FormsModule,
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
