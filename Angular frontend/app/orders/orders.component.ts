import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { TransferService } from '../transfer.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  responseBack : any;
  constructor(private httpRef: HttpClient, private router: Router, private myService: TransferService) { }

  ngOnInit(): void {
    let obs = this.httpRef.get("http://localhost:8083/orders/"+this.myService.userid1());
    obs.subscribe((responseBack) => {
      this.responseBack = responseBack;
      console.log(this.responseBack);
    });
  }

  toRemove(val){
    console.log(val);
    return this.httpRef.delete("http://localhost:8083/orders/cancel/" + val).subscribe((response) => {
    console.log("Deleted Successfully");
    window.location.reload();
  }
    );
  
  
  }

  itemDescription(val){
    console.log(val);
    this.router.navigate(['/itemDescription',val])
  }

}
