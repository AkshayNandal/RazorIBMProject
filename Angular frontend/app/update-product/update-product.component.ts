import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  productId:any=null;
  productCategory:any;
  productDescription:any;
  productName:any;
  productPrice:any;
  productSubCategory:any;
  unitStock:any;
  productImage:any;

  constructor(private httpRef:HttpClient,private router:Router,private _ActivatedRoute: ActivatedRoute) { }

  updateProduct(){
    let obs=this.httpRef.put('http://localhost:8083/products/update',{
    "productId":this.productId,
    "productCategory":this.productCategory,
    "productSubCategory":this.productSubCategory,
    "productDescription":this.productDescription,
    "productName":this.productName,
    "productPrice":this.productPrice,
    "unitStock":this.unitStock,
    "productImage":this.productImage
    });
    obs.subscribe((data)=>{
      console.log("Updated");
      this.router.navigate(['/getproduct']);
      // window.location.reload();
    }
  );
  }

  ngOnInit(): void {
    this.productId=this._ActivatedRoute.snapshot.paramMap.get("p1");
  }

}
