import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { TransferService } from '../transfer.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  responseBack : any;
  productName : any=null;
  constructor(private httpRef : HttpClient, private router : Router, private myService : TransferService, private _Activatedroute: ActivatedRoute) { }

  ngOnInit(): void {
    this.productName = this._Activatedroute.snapshot.paramMap.get("p1");
    let obs = this.httpRef.get("http://localhost:8083/products/name/" + this.productName);
    obs.subscribe((responseBack) => {
      this.responseBack = responseBack;
      console.log(this.responseBack);
    });
  }
  itemDescription(val){
    console.log(val);
    this.router.navigate(['/itemDescription',val])
  }

}
