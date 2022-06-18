import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {UserAreaModule} from "./module/user.area.module";

const routes: Routes = [
  {

  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes), UserAreaModule],
  exports: [RouterModule],
  declarations: [
  ]
})
export class UserRoutingModule {
}
