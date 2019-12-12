import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { RequestbloodComponent } from './requestblood/requestblood.component';
import { DonatebloodComponent } from './donateblood/donateblood.component';
import { HospitalComponent } from './hospital/hospital.component';


const routes: Routes = [ { path: 'signup', component: SignupComponent},
{path: 'login',component:LoginComponent},
{path:'home',component:HomeComponent},
{path:'search',component:SearchComponent},
{path:'request',component:RequestbloodComponent},
{path:'donate',component:DonatebloodComponent},
{path:'hospital',component:HospitalComponent},
{path:'search',component:SearchComponent},
{path:'requestlist',component:RequestbloodComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
