import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CrisisListComponent } from './component/crisis-list/crisis-list.component';
import { HeroesListComponent } from './component/heroes-list/heroes-list.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { LoginComponent } from './component/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SensorsComponent } from './component/sensors/sensors.component';

@NgModule({
  declarations: [
    AppComponent,
    CrisisListComponent,
    HeroesListComponent,
    NavbarComponent,
    LoginComponent,
    SensorsComponent
  ],
  imports: [
    BrowserModule,
     // import HttpClientModule after BrowserModule.
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: 'sensors', component: SensorsComponent},
      {path: 'heroes-list', component: HeroesListComponent},
      {path: 'login', component: LoginComponent}
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
