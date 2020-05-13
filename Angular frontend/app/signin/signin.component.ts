import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { TransferService } from '../transfer.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  email:string="";
  password:string="";
  url:string="";
  responseBack:any;
  constructor(private httpRef:HttpClient, private router: Router,private myService:TransferService) { }
  ngOnInit(): void {
  }

  login(){
    if(this.email == "admin@gmail.com" && this.password == "admin"){
      this.router.navigate(['/admin']);
    }
    else{
      let obs=this.httpRef.get("http://localhost:8081/login/"+this.email+"/"+this.password,{
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text' 
   }).subscribe(
    (data) =>{
      console.log(data);
      if(data == "success"){
        alert("login successfull");
        this.myService.store(this.email);
        this.router.navigate(['/home']);
      }
      else if(data == "passwordFailed"){
        alert("Invalid Password");
      }
      else{
        alert("Invalid Username");
      }
      
    }
  );
  }
  }
  displayMessage(val){
    console.log(val);
  }
}
