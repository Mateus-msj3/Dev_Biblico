import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserAreaComponent} from "./components/user-area/user-area.component";
import {AuthGuard} from "../../auth.guard";


const routes: Routes = [
  {
    path: 'users', component: UserAreaComponent, canActivate: [AuthGuard], children: [
      {path: 'new', component: UserAreaComponent, canActivate: [AuthGuard]},
      {path: 'edit/:id', component: UserAreaComponent, canActivate: [AuthGuard]},
    ]
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {
}
