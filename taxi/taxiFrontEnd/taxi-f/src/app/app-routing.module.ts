import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
// import {MainComponent} from './components/main/main/main.component';
import {ViewRolesTableComponent} from './components/main/roles/view-roles-table/view-roles-table.component';
import {ViewCarTableComponent} from './components/main/car/view-car-table/view-car-table.component';
import {ViewUsedCarTableComponent} from './components/main/used-car/view-used-car-table/view-used-car-table.component';
import {ViewUserTaxiTableComponent} from './components/main/user/view-user-taxi-table/view-user-taxi-table.component';
import {ViewTripTableComponent} from './components/main/trip/view-trip-table/view-trip-table.component';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {LoginComponent} from './components/auth/login/login.component';
import {RegisterComponent} from './components/auth/register/register.component';
import {TitleComponent} from './components/main/title/title.component';
import {ProfileComponent} from './components/auth/profile/profile.component';


// const routes: Routes = [];
const appRoutes: Routes = [
  {path: '', component: TitleComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'car', component: ViewCarTableComponent},
  {path: 'role', component: ViewRolesTableComponent},
  {path: 'usedcar', component: ViewUsedCarTableComponent},
  {path: 'usertaxi', component: ViewUserTaxiTableComponent},
  {path: 'trip', component: ViewTripTableComponent},
  {path: 'profile', component: ProfileComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes), BrowserModule],
  // tslint:disable-next-line:max-line-length
  // declarations: [ViewCarTableComponent, ViewRolesTableComponent, ViewUsedCarTableComponent, ViewUserTaxiTableComponent, ViewTripTableComponent],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
