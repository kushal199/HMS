import { Component, OnInit } from '@angular/core';
import { NgserviceService } from 'src/app/ngservice.service';
import { Router } from '@angular/router';
import { User } from 'src/app/user';

@Component({
  selector: 'app-view-doc',
  templateUrl: './view-doc.component.html',
  styleUrls: ['./view-doc.component.css']
})
export class ViewDocComponent implements OnInit {
  users!: User[];
  u:User=new User();
  id: any;
  constructor(private service:NgserviceService,private router:Router) { 
    
  }

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers(){
    this.service.fetchuserdetails().subscribe(data =>{
      this.users=data;
    }
      // data=> console.log("response recieved"),
      // error=> console.log("error recieved")

    );

  }

}
