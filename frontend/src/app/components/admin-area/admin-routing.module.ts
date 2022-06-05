import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserAdminAreaComponent} from "./components/user-admin-area/user-admin-area.component";
import {AuthGuard} from "../../auth.guard";


const routes: Routes = [
  {
    path: 'users', component: UserAdminAreaComponent, canActivate: [AuthGuard], children: [
      {path: 'new', component: UserAdminAreaComponent, canActivate: [AuthGuard]},
      {path: 'edit/:id', component: UserAdminAreaComponent, canActivate: [AuthGuard]},
    ]
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {
}
