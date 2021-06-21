import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingComponent } from './landing/landing/landing.component';
import { LoginpageComponent } from './admin/loginpage/loginpage.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { DashboardAdminComponent } from './admin/dashboard-admin/dashboard-admin.component';
import { RegistrationDocComponent } from './admin/registration-doc/registration-doc.component';
import { ViewDocComponent } from './admin/view-doc/view-doc.component';


@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    LoginpageComponent,
    DashboardAdminComponent,
    RegistrationDocComponent,
    ViewDocComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
