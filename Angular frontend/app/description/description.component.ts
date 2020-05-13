import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TransferService } from '../transfer.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CartComponent } from '../cart/cart.component';

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css']
})
export class DescriptionComponent implements OnInit {
   id : any=null;
  constructor(private myService : TransferService, private httpRef : HttpClient, private router : Router, private _Activatedroute: ActivatedRoute) { }
  
  
  response : any;
  isOn : boolean = false;

  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("p1");
    console.log("recieved" +this.id);
    let obs = this.httpRef.get("http://localhost:8083/products/id/"+this.id);
    obs.subscribe((response) => 
    this.response = response
    );
  //  let obs = this.router.getCurrentNavigation().extras.state;
  //   console.log(obs);
  //   this.responseBack = obs;
  }
  addcart(val){
     let obs= this.httpRef.post("http://localhost:8083/cart/add/" + val+"/"+this.myService.userid1(),this.response)
     obs.subscribe((data) => {
     console.log("Added Successfully");
     this.router.navigate(['/cart']);
     }
     );
    
  }

  addwish(){
    let obs= this.httpRef.post("http://localhost:8083/wishList/add/"+this.myService.userid1(),this.response)
    obs.subscribe((data) => {
    console.log("Added Successfully");
    this.isOn = !this.isOn;
    window.location.reload();
    }
    );
  }

  removewish(val){
    console.log(val);
    return this.httpRef.delete("http://localhost:8083/wishList/" + val).subscribe((response) => {
    console.log("Deleted Successfully");
    this.isOn = !this.isOn;
    window.location.reload();
  }
    );
  }

}
