import { Component, OnInit } from '@angular/core';
import { TransferService } from '../transfer.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {
response : any;
  constructor(private httpRef: HttpClient,private myService: TransferService) { }

  ngOnInit(): void {
    let obs = this.httpRef.get("http://localhost:8081/users/details/"+this.myService.store1());
    obs.subscribe((responseBack) => {
      this.response = responseBack;
      console.log(responseBack);
    });
  }

}
