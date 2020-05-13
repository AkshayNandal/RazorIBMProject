import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-products',
  templateUrl: './get-all-products.component.html',
  styleUrls: ['./get-all-products.component.css']
})
export class GetAllProductsComponent implements OnInit {
  products:any;
 constructor(private httpRef:HttpClient, private router:Router){}
 
 public deleteProduct(id:any){
   let obs=this.httpRef.delete("http://localhost:8083/products/"+id);
   obs.subscribe((data)=>{
    console.log(data);
    window.location.reload();
   });
 }
ngOnInit(): void {
    let obs=this.httpRef.get("http://localhost:8083/products");

    obs.subscribe((data)=>{this.products=data;
    console.log(data);
    });
  }

  updateProduct(val){
    this.router.navigate(['/update',val])
  }

}
