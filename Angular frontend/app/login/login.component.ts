import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{
  firstName;
  lastName;
  phoneNumber;
  email;
  password;
  gender;
  city;
  url:string;
  responseBack:any;
  constructor(private httpRef:HttpClient, private router:Router) { }
 register(){
    let obs=this.httpRef.post("http://localhost:8081/register/users",
    {
      "firstName":this.firstName,
      "lastName":this.lastName,
      "phoneNumber":this.phoneNumber,
      "email":this.email,
      "password":this.password,
      "gender":this.gender,
      "city":this.city
    },{
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text' 
   }).subscribe((data )=>{
    console.log(data);
    
     if(data == "Success"){
       this.router.navigate(['/otp']);
     }
     else{
       alert("User already exists, please login");
       this.router.navigate(['/signin']);
     }
    }
   
  );
 
  }
  displayMessage(val){
    console.log(val);
  }
 
 
}



