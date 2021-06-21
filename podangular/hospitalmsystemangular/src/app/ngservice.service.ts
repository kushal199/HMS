import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class NgserviceService {
  private baseURL = 'http://localhost:8080/save_appointment';
  constructor(private _http:HttpClient,private router:Router) { }

  fetchuserdetails():Observable<any>{
    return this._http.get<any>("http://localhost:8080/view_doc");
  }
  getOne(id:number):Observable<any>{
    return this._http.post<any>("http://localhost:8080/new_user",id);
  }

  login_admin(user:Object):Observable<any>{
     return this._http.post<any>("http://localhost:8080/login-user",user);
   }

   doctor_reg(user:Object):Observable<any>{
    return this._http.post<any>("http://localhost:8080/save",user);
  }


}
