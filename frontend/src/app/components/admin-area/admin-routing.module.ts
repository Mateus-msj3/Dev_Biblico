import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserAreaComponent} from "./components/user-area/user-area.component";
import {AuthGuard} from "../../auth.guard";
import {AdminAreaComponent} from "./admin-area.component";


const routes: Routes = [

  { path: 'admin', component: AdminAreaComponent, },
  { path: 'users', component: UserAreaComponent, canActivate:[AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
