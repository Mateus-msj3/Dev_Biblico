import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {NavbarUserComponent} from "../components/navbar-user/navbar-user.component";
import {UserAreaComponent} from "../user-area.component";
import {DevotionalCrudComponent} from "../components/devotional.crud/devotional.crud.component";
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
import {InputTextModule} from "primeng/inputtext";
import {ButtonModule} from "primeng/button";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CardModule} from "primeng/card";
import {AutoCompleteModule} from "primeng/autocomplete";
import {CheckboxModule} from "primeng/checkbox";
import {CalendarModule} from "primeng/calendar";

@NgModule({
  declarations: [
    UserAreaComponent,
    NavbarUserComponent,
    DevotionalCrudComponent,
  ],

  exports: [
    UserAreaComponent,
    NavbarUserComponent,
    DevotionalCrudComponent,
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
    DropdownModule,
    InputTextModule,
    ButtonModule,
    BrowserAnimationsModule,
    CardModule,
    AutoCompleteModule,
    CheckboxModule,
    CalendarModule,
  ],


  providers: [
  ],
})
export class UserAreaModule { }
