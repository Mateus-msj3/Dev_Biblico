import { AdminAreaComponent } from './components/admin-area/admin-area.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './components/index/index.component';
import {AuthGuard} from "./auth.guard";
import {UserAreaComponent} from "./components/admin-area/components/user-area/user-area.component";

const routes: Routes = [
  { path: '', component: IndexComponent},

  { path: 'login', component: LoginComponent},
  // { path: 'admin', component: AdminAreaComponent, canActivate:[AuthGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
