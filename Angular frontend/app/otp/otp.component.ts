import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.css']
})
export class OtpComponent implements OnInit {

  otp:string="";
  url:string="";
  responseBack:any;
  constructor(private httpRef:HttpClient, private router: Router) { }

  ngOnInit(): void {
  }
  otpNumber(){
    let obs=this.httpRef.get("http://localhost:8081/validateOtp/"+this.otp,{
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text' 
   }).subscribe(
    (data) =>{
      console.log(data);
      if(data == "valid"){
        alert("Account created Successfully!! Signin");
        this.router.navigate(['/signin']);
      }
      else{
        alert("Invalid otp!!");
      }
    }
  );
  }
}
