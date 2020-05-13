import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {


  productCategory:string="";
  productDescription:string="";
  productName:string="";
  productPrice:number=0;
  productSubCategory:string="";
  unitStock:string="";
  productImage:string="";
  responseBack:any;
  constructor(private httpRef:HttpClient, private router:Router) { }

  addProduct(){
    let obs=this.httpRef.post("http://localhost:8081/products",
    {
      "productCategory":this.productCategory,
      "productSubCategory":this.productSubCategory,
      "productDescription":this.productDescription,
      "productName":this.productName,
      "productPrice":this.productPrice,
      "unitStock":this.unitStock,
      "productImage":this.productImage
      
    });
    obs.subscribe((data )=>{
      this.router.navigate(['/getproduct']);
      console.log("post success");
      // window.location.reload();
    }
   
  );
  }

  ngOnInit(): void {
  }

}
