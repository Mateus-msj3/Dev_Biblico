import { AdminAreaComponent } from './components/admin-area/admin-area.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './components/index/index.component';

const routes: Routes = [
  { path: '', component: IndexComponent, children: [
    { path: 'home', component: HomeComponent},

  ]},

  { path: 'login', component: LoginComponent},
  { path: 'admin', component: AdminAreaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
