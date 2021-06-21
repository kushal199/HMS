import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-registration-doc',
  templateUrl: './registration-doc.component.html',
  styleUrls: ['./registration-doc.component.css']
})
export class RegistrationDocComponent implements OnInit {
  ex: any;
  u:User=new User();

  constructor(private service:NgserviceService,private router:Router) {
   
   }

  ngOnInit(): void {
  }
  submit(value:any){
    console.log(value);
    this.save(value);
    this.router.navigate(['view_doc']);
  }
  save(value:any){
    this.service.doctor_reg(value).subscribe(data=>{
      this.ex=data;
      console.log(this.ex);
    });
  }
 

}
