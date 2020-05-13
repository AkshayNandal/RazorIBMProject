import { Component, OnInit, AfterViewChecked } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

declare let paypal:any;

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit,AfterViewChecked{

  addScript : boolean = false;
  finalAmount: any = null;
  
  constructor(private router:Router,private _ActivatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.finalAmount=this._ActivatedRoute.snapshot.paramMap.get("p1");
  }

  paypalConfig={
    env:'sandbox',
    client:{
      sandbox:'ATpVfaBCt3HmDxdnsBfhF0WPeN4KqfI0PLxwbLmzwWdlDYo2uer8si1Hx6fhMP8d1VradUhizcYXtWvK',
    },
    commit:true,
    payment:(data, actions)=>{
      return actions.payment.create({
        payment:{
          transactions:[
            {amount:{total: this.finalAmount,currency:'INR'}}
          ]
        }
      });
    },
    onAuthorize:(data,actions)=>{
      return actions.payment.execute().then((payment)=>{
        this.router.navigate(['/orders'])
      })
    }
  };
  ngAfterViewChecked():void{
    if(!this.addScript){
      this.addPaypalScript().then(()=>{
        paypal.Button.render(this.paypalConfig,'#paypal-checkout-btn')

      })
  }
}
  addPaypalScript(){
    this.addScript=true;
    return new Promise((resolve,reject)=>{
      let scripttagElement = document.createElement('script');
      scripttagElement.src='https://www.paypalobjects.com/api/checkout.js';
      scripttagElement.onload=resolve;
      document.body.appendChild(scripttagElement);
    })
  }
}
