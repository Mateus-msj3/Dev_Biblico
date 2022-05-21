import {LoginComponent} from './components/login/login.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from './components/index/index.component';
import {AdminAreaComponent} from "./components/admin-area/admin-area.component";
import {AuthGuard} from "./auth.guard";
const routes: Routes = [
  {
    path: '', component: IndexComponent, children: []
  },

  {path: 'admin', component: AdminAreaComponent, canActivate: [AuthGuard]},

  {path: 'login', component: LoginComponent  ,children: [
      {path: 'sub', component: LoginComponent},
    ]}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
