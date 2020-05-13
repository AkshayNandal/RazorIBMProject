import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { TransferService } from '../transfer.service';

@Component({
  selector: 'app-fashion',
  templateUrl: './fashion.component.html',
  styleUrls: ['./fashion.component.css']
})
export class FashionComponent implements OnInit {

  responseBack1 : any;
  responseBack2 : any;
  responseBack3 : any;
  responseBack4 : any;

  constructor(private httpRef : HttpClient, private router : Router, private myService : TransferService) { }
  ngOnInit(): void {
    let obs = this.httpRef.get("http://localhost:8083/products/subCategory/t-shirt");
    obs.subscribe((responseBack) => {
      this.responseBack1 = responseBack;
      console.log(this.responseBack1);
    });

    let obs1 = this.httpRef.get("http://localhost:8083/products/subCategory/jeans");
    obs1.subscribe((responseBack) => {
      this.responseBack2 = responseBack;
      console.log(this.responseBack2);
    });

    let obs2 = this.httpRef.get("http://localhost:8083/products/subCategory/shirt");
    obs2.subscribe((responseBack) => {
      this.responseBack3 = responseBack;
      console.log(this.responseBack3);
    });

    let obs3 = this.httpRef.get("http://localhost:8083/products/subCategory/trouser");
    obs3.subscribe((responseBack) => {
      this.responseBack4 = responseBack;
      console.log(this.responseBack4);
    });
  }

  itemDescription(val){
    console.log(val);
    this.router.navigate(['/fashionDescription',val]);
  }

}
