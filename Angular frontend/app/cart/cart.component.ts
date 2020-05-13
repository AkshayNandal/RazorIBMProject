import { Component, OnInit } from '@angular/core';
import { TransferService } from '../transfer.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HeadingComponent } from '../heading/heading.component';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  responseBack : any;
  responseBack1 : any;
  
  constructor(private httpRef : HttpClient, private myService : TransferService, private router : Router) { }
  ngOnInit(): void {
    let obs = this.httpRef.get("http://localhost:8083/cart/"+this.myService.userid1());
    obs.subscribe((responseBack) => {
      this.responseBack = responseBack;
      console.log(this.responseBack);
    });

    let obs1 = this.httpRef.get("http://localhost:8083/cart/total/"+this.myService.userid1());
    obs1.subscribe((responseBack) => {
      this.responseBack1 = responseBack;
      console.log(this.responseBack);
      
    });
  }

  toRemove(val){
    console.log(val);
    return this.httpRef.delete("http://localhost:8083/cart/" + val).subscribe((response) => {
    console.log("Deleted Success");
    window.location.reload();
  }
    );
  
  
  }

  itemDescription(val){
    console.log(val);
    this.router.navigate(['/itemDescription',val])
  }

  increment(val){
    console.log(val);
    return this.httpRef.post("http://localhost:8083/cart/increment",val).subscribe((response) => {
      console.log("incremented");
      window.location.reload();
    });
  }

  decrement(val){
    console.log(val);
    return this.httpRef.post("http://localhost:8083/cart/decrement",val).subscribe((response) => {
      console.log("decremented");
      window.location.reload();
    });
  }

  place(val){
    console.log(this.responseBack);
    for(let item of this.responseBack){
      this.httpRef.post("http://localhost:8083/orders/"+this.myService.userid1(),item).subscribe((response) => {
      console.log("added to orders");
    });
      this.httpRef.delete("http://localhost:8083/cart/removeAll/"+item.cartId).subscribe((response) => {
      console.log("deleted cart");
    });
  }
  this.router.navigate(['/payment',val]);
  }
}
