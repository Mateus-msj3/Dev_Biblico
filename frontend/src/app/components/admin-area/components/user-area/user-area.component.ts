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

  display2: boolean = false;

  errorDialog: boolean = false;

  deleteDialog: boolean = false;

  enabledFormEditOneUser: boolean = false;

  enabledFiledsEditOneUser: boolean = true;

  closeEditOneUser: boolean = false;

  errors?: String[];

  selectedUser!: User;

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
        this.userService.getUserById(this.id).subscribe(sucessResponse => {
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

  filterUserByEmail() {
    this.userService.getUserByEmail(this.user.email).subscribe(sucessResponse => {
      this.enabledFormEditOneUser = true;

      this.user.id = sucessResponse.id;
      this.user.username = sucessResponse.username;
      this.user.email = sucessResponse.email;
      this.user.password = sucessResponse.password;
      this.user.role = sucessResponse.role;

    }, errorResponse => {
        console.log("Usuário não encontrado!");
    });
  }

  saveUser() {
    debugger
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

  openEditUser(user: User) {
    this.display = true;
    this.setValueEditFormUser(user);
  }

  editUser(user: User) {
    this.userService.update(this.user).subscribe(sucessResponse => {
      this.sucessDialog = true;
    }, errorResponse => {
      this.errorDialog = true;
    });
  }

  setValueEditFormUser(user: User) {
    this.user.username = user.username;
    this.user.email = user.email;
    this.user.password = user.password;
  }

  enabledEditOneUser(user: User) {
    debugger
    this.enabledFiledsEditOneUser = false
  }

  cancelEditOneUser(event: MouseEvent) {
    this.enabledFormEditOneUser = false
  }

  openDeleteUser(user: User) {
    this.deleteDialog = true;
    this.selectedUser = user;
  }

  closeDeleteUser() {
    this.deleteDialog = false;
  }

  deleteUser(user: User) {
    this.userService.delete(this.selectedUser).subscribe(sucessResponse => {
      this.sucessDialog = true;
      this.closeDeleteUser();
      this.getUsers();
    }, error => {
      this.errorDialog = true;
    })
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

  openListUser() {
    this.display2 = true;
  }
}
