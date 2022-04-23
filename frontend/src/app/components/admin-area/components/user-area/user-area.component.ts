import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../../shared/services/user.service";
import {User} from "../../../../shared/models/user";
import {Role} from "../../../../shared/models/role";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-user-area',
  templateUrl: './user-area.component.html',
  styleUrls: ['./user-area.component.css']
})
export class UserAreaComponent implements OnInit {

  user: User = new User();

  users: User[] = [];

  roles: Role[] = [];

  sucessDialog: boolean = false;

  display: boolean = false;

  errorDialog: boolean = false;

  errors?: String[];

  selectedUser: any;

  profiles: any;

  selectedProfile: any;

  id?: number;

  constructor(private userService: UserService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {

    this.roles = [
      {name: "ROLE_ADMIN"},
      {name: "ROLE_USER"}
    ];

  }

  ngOnInit(): void {
    this.getUsers();
    this.paramsRoute();
  }

  paramsRoute() {
    this.activatedRoute.params.subscribe(value => {
      this.id = value['id'];
      if (value.id) {
        this.userService.getuserById(this.id).subscribe(sucessResponse => {
          this.user = sucessResponse;
        }, errorResponse => {
          this.user = new User();
        })
      }
    });
  }

  getUsers() {
    this.userService.getUser().subscribe(response => {
      this.users = response;
    });
  }

  saveUser() {
    if (!this.user.id) {
      this.userService.save(this.user).subscribe(sucessResponse => {
        this.sucessDialog = true;
        this.clearFormNewUser();
        this.getUsers();
      }, errorResponse => {
        this.errorDialog = true;
      });
    } else {
      this.editUser(this.user);
      this.getUsers()
    }

  }

  clearFormNewUser() {
    this.user.username = "";
    this.user.email = "";
    this.user.password = "";
  }

  openNewUser() {
    this.display = true;
    this.router.navigate(['/users/new']);
  }

  closeNewUser() {
    this.display = false;
  }

  openEditUser() {
    this.display = true;
    this.setValueEditFormUser();
  }

  editUser(user: User) {
    this.userService.update(this.user).subscribe(sucessResponse => {
      this.sucessDialog = true;
    }, errorResponse => {
      this.errorDialog = true;
    });
  }

  setValueEditFormUser() {
    this.user.username = this.user.username;
    this.user.email = this.user.email;
    this.user.password = this.user.password;
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
