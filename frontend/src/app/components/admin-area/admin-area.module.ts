import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserAreaComponent} from "./components/user-area/user-area.component";
import {RouterModule} from "@angular/router";
import { NavbarAdminComponent } from './components/navbar-admin/navbar-admin.component';
import {TableModule} from "primeng/table";
import {ToolbarModule} from "primeng/toolbar";
import {FileUploadModule} from "primeng/fileupload";
import {RatingModule} from "primeng/rating";
import {DialogModule} from "primeng/dialog";
import {DropdownModule} from "primeng/dropdown";
import {RadioButtonModule} from "primeng/radiobutton";
import {InputNumberModule} from "primeng/inputnumber";
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {FormsModule} from "@angular/forms";
import {ConfirmationServiceService} from "../../shared/services/confirmation-service.service";
import {ConfirmationService} from "primeng/api";



@NgModule({
  declarations: [
    UserAreaComponent,
    NavbarAdminComponent
  ],

  exports: [
    UserAreaComponent,
    NavbarAdminComponent
  ],

  imports: [
    CommonModule,
    RouterModule,
    TableModule,
    ToolbarModule,
    FileUploadModule,
    RatingModule,
    DialogModule,
    DropdownModule,
    RadioButtonModule,
    InputNumberModule,
    ConfirmDialogModule,
    FormsModule,
  ],


  providers: [
    ConfirmationService
  ],
})
export class AdminAreaModule { }