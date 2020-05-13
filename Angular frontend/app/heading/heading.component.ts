import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransferService } from '../transfer.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-heading',
  templateUrl: './heading.component.html',
  styleUrls: ['./heading.component.css']
})
export class HeadingComponent implements OnInit {

  responseBack : any;
  responseBack2 : any;
  responseBack3 : any;

  productName : string = "";

  constructor(private router : Router, private httpRef : HttpClient, private myService : TransferService) { }
  ngOnInit(): void {
    let obs = this.httpRef.get("http://localhost:8083/cart/count/"+this.myService.userid1());
    obs.subscribe((responseBack) => {
      this.responseBack = responseBack;
      console.log(this.responseBack);
    });

    let obs2 = this.httpRef.get("http://localhost:8081/users/details/"+this.myService.store1());
    obs2.subscribe((data) => {
      this.responseBack3 = data;
      console.log(this.responseBack3);
      this.myService.userid(this.responseBack3.userId);
    });

    let obs1 = this.httpRef.get("http://localhost:8083/wishList/count/"+this.myService.userid1());
    obs1.subscribe((responseBack) => {
      this.responseBack2 = responseBack;
      console.log(this.responseBack);
    });
  }

  cartpage(){
    this.router.navigate(['/cart']);
  }
  wishlist(){
    this.router.navigate(['/wishlist']);
  }
  searching(val){
    console.log(val);
    this.router.navigate(['/search',val]);
  }
  logout(){
    localStorage.removeItem("val");
    localStorage.removeItem("user");
    this.router.navigate(['/signin']);
  }
}
