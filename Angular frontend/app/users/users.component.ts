import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users:any;
  constructor(private httpRef:HttpClient) { }

  ngOnInit(): void {
    let obs=this.httpRef.get("http://localhost:8081/users");
    obs.subscribe((data)=>this.users=data);
  }

}
