import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ApiService } from '../api.service';
@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  submitted=false;
  fg: FormGroup;
  post:any='';
  constructor(
    private fb:FormBuilder,
    private api:ApiService,
    private _router:Router,
    private toast:ToastrService
    ) {
    this.createForm();
   }

  ngOnInit(): void {
  }

  createForm(){
    this.fg=this.fb.group({
      'name':['',Validators.required],
      'pass':['',Validators.required],
    })
  }

  validate(values:any){
    this.submitted=true;
    //console.log(this.fg.valid)
    if(this.fg.valid){
      console.log(values)
      this.api.adminValidate(values).subscribe({
        next:resp=>{
        console.log(resp)
        this.toast.success('Welcome '+resp.data.name,"Login Successful")
        sessionStorage.setItem("role","A")
          this._router.navigate(['add-book'])
        },
      error:err=>{
        console.log(err)
        this.toast.error('Invalid userid or password',"Login Failed")
      }
    })
  }
  }

  

}
