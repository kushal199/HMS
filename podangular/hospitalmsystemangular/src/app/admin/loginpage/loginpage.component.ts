import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  ex:User=new User();
  u:User=new User();

  constructor(private service:NgserviceService,private router:Router) {
   
   }

  ngOnInit(): void {
  }
  submit(value:any){
    console.log(value);
    this.login_admn(value);
    //this.router.navigate(['loginpage']);
  }

  login_admn(value:any){
    this.service.login_admin(value).subscribe(data =>{
      this.ex=data;
      
      
      console.log(this.ex);
      if(this.ex.doctor_id==0){
        this.router.navigate(['loginpage']);
      }else{
     
       
         this.router.navigate(['dashboard_admin']);
      }
    });
  }
 
  }
  
 


