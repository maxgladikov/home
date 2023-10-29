import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { RouterModule } from '@angular/router';
// import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { LoginComponent } from './component/login/login.component';
import { SensorsComponent } from './component/sensors/sensors.component';
import { ChartComponent } from './component/chart/chart.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    SensorsComponent,
    ChartComponent,
  ],
  imports: [
    BrowserModule,
     // import HttpClientModule after BrowserModule.
    HttpClientModule,
    // FormsModule,
    // ReactiveFormsModule,
    MatTableModule ,
    RouterModule.forRoot([
      {path: 'chart', component: ChartComponent},
      {path: 'sensors', component: SensorsComponent},
      {path: 'login', component: LoginComponent}
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
