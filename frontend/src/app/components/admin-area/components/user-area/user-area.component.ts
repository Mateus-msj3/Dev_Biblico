import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../../shared/services/user.service";
import {User} from "../../../../shared/models/user";
import {roleEnum} from "../../../../shared/models/roleEnum";
import {Role} from "../../../../shared/models/role";

@Component({
  selector: 'app-user-area',
  templateUrl: './user-area.component.html',
  styleUrls: ['./user-area.component.css']
})
export class UserAreaComponent implements OnInit {

  user: User = new User() ;

  users: User[] = [];

  roles: Role[] = [];

  sucessDialog: boolean = false;

  display: boolean = false;

  errorDialog: boolean = false;

  errors?: String[];

  selectedUser: any;

  profiles: any;

  selectedProfile: any;

  constructor(private userService: UserService) {

    this.roles = [
      {name: "ROLE_ADMIN"},
      {name: "ROLE_USER"}
    ];

  }

  ngOnInit(): void {

    this.userService.getUser().subscribe(response => {
      this.users = response;
    });

  }

  saveUser() {
    this.userService.save(this.user).subscribe(sucessResponse => {
      console.log(sucessResponse)
      console.log(this.user)
      this.sucessDialog = true;
      this.user.username = "";
      this.user.email = "";
      this.user.password = "";

    }, errorResponse => {
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

  onChangeValueRole(event: any) {
    event.value
  }

}
