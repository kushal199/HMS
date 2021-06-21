import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardAdminComponent } from './admin/dashboard-admin/dashboard-admin.component';
import { LoginpageComponent } from './admin/loginpage/loginpage.component';
import { RegistrationDocComponent } from './admin/registration-doc/registration-doc.component';
import { ViewDocComponent } from './admin/view-doc/view-doc.component';
import { LandingComponent } from './landing/landing/landing.component';


const routes: Routes = [
  {path:"landing",component:LandingComponent},
  {path:"loginpage",component:LoginpageComponent},
  {path:"dashboard_admin",component:DashboardAdminComponent},
  {path:"regpage",component:RegistrationDocComponent},
  {path:"view_doc",component:ViewDocComponent}
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
