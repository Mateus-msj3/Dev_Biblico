import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserAreaComponent} from "./components/user-area/user-area.component";
import {AdminAreaComponent} from "./admin-area.component";


const routes: Routes = [
  // { path: '', component: AdminAreaComponent, children: [
  //   { path: 'users', component: UserAreaComponent},
  //
  // ]},

  { path: 'users', component: UserAreaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
