import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { CategoryComponent } from './category/category.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { OrdersComponent } from './orders/orders.component';
import { ProductsComponent } from './products/products.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { UsersComponent } from './users/users.component';
import { ViewcartComponent } from './viewcart/viewcart.component';

import {AddBookComponent} from '../app/add-book/add-book.component'
import {CartAddComponent} from '../app/cart-add/cart-add.component'
import {CartViewComponent} from '../app/cart-view/cart-view.component'

 
const routes: Routes = [
  {path:'', component:HomeComponent,pathMatch:'full'},
  {path:'dashboard',component:DashboardComponent},
  {path:'login',component:LoginComponent},
  
  {path:'register',component:RegisterComponent},
  {path:'category',component:CategoryComponent},
  {path:'products',component:ProductsComponent},
  {path:'orders',component:OrdersComponent},
  {path:'profile',component:ProfileComponent},

  {path:'users',component:UsersComponent},
  {path:'viewcart',component:ViewcartComponent},
  {path:'history',component:OrderhistoryComponent},
  {path:'adminlogin',component:AdminLoginComponent},
  {path:'add-book',component:AddBookComponent},
  {
    path:'profile/cartAdd/:id',
  component:CartAddComponent
},
{
  path:'cartAdd/:id',
component:CartAddComponent
},
{
  path:'cartView',
component:CartViewComponent
},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
