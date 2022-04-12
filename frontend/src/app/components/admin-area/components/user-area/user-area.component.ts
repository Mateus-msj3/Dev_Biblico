import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../../shared/services/user.service";
import {User} from "../../../../shared/models/user";
import {roleEnum} from "../../../../shared/models/roleEnum";

@Component({
  selector: 'app-user-area',
  templateUrl: './user-area.component.html',
  styleUrls: ['./user-area.component.css']
})
export class UserAreaComponent implements OnInit {

  user: User = new User() ;

  users: User[] = [];

  roles: roleEnum[] = [];

  // let colorValueArray = Object.values(roleEnum);

  selectedRole?: roleEnum;

  sucessDialog: boolean = false;

  display: boolean = false;

  errorDialog: boolean = false;

  errors?: String[];

  profiles: any;

  selectedProfile: any;

  selectedUser: any;

  teste: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUser().subscribe(response => {
      this.users = response;
    });

    this.roles = []
  }

  saveUser() {
    this.userService.save(this.user).subscribe(sucessResponse => {
      this.sucessDialog = true;
      this.user.username = "";
      this.user.email = "";
      this.user.password = "";

    }, errorResponse => {
      console.log(errorResponse.error.errors);
      this.errors = errorResponse.error.errors;
      this.errorDialog = true;
    })
  }

  openNewUser() {
    this.display = true;
  }

  closeNewUser() {
    this.display = false;
  }

  editUser(user: User) {

  }

  deleteUser(user: User) {

  }

  closeDialogSuccess() {
    this.sucessDialog = false;
    this.display = false;
  }

  closeDialogError() {
      this.errorDialog = false;
  }

  getEnumToArray(type: any): Array<any> {
    let enumToArray = new Array();
    for (let key in type) {
      enumToArray.push(type[key]);
    }
    return enumToArray;
  }



}
