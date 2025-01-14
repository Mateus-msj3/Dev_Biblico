import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../../shared/services/user.service";
import {User} from "../../../../shared/models/user";
import {Role} from "../../../../shared/models/role";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-user-area',
  templateUrl: './user-admin-area.component.html',
  styleUrls: ['./user-admin-area.component.css']
})
export class UserAdminAreaComponent implements OnInit {

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

  errors?: String[];

  selectedUser!: User;

  id?: number;

  emailFilter!: string;

  nameFilter!: string;

  resultsUsersByUsername: User[] = [];

  filterByName: boolean = false;

  filterByEmail: boolean = false;

  options: any[] = [{name: 'Filtrar por nome', key: '1'}, {name: 'Filtrar por email', key: 2}];

  optionSelected: any = null;

  constructor(private userService: UserService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {

    this.roles = [
      {name: "ROLE_ADMIN"},
      {name: "ROLE_USER"}
    ];

  }

  ngOnInit(): void {
    debugger
    //this.getUsers();
    this.paramsRoute();
    this.filterByName = true;
    this.optionSelected = this.options[0];
    this.getUsers();
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
    this.userService.getUser().then(response => {
      this.users = response;
    });
  }

  selectTypeFilter(event: MouseEvent) {
    if (this.optionSelected == this.options[0]) {
      this.filterByEmail = false;
      this.filterByName = true

    } else if (this.optionSelected == this.options[1]) {
      this.filterByName = false;
      this.filterByEmail = true;
    }
  }

  showDetailsOneUser(user: User) {
    this.enabledFormEditOneUser = true;

    this.user.id = user.id;
    this.user.username = user.username;
    this.user.email = user.email;
    this.user.password = user.password;
    this.user.role = user.role;
  }

  filterUserByEmail() {
    debugger
    if (this.emailFilter == undefined) {
      //Fazer um dialog de informação
      this.sucessDialog = true
    } else {
      this.userService.getUserByEmail(this.emailFilter).subscribe(sucessResponse => {
        this.showDetailsOneUser(sucessResponse)

      }, errorResponse => {
        console.log("Usuário não encontrado!");
      });
    }

  }

  filterUserByName(event: any) {
    debugger
    //lista
    let filtered: any[] = [];
    let query = event.query;
    //requisição
    this.userService.getUserByUsername(this.nameFilter).then(users => {
      filtered = users;
    });

    for (let i = 0; i < this.users.length; i++) {
      let user: any = this.users[i];
      if (user.username.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        filtered.push(user);
      }
    }

    this.resultsUsersByUsername = filtered;
  }

  onSelectedUserByName(event: any) {
    this.showDetailsOneUser(event);
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
    this.user.id = user.id
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
    debugger
    //Esta condiçao será chamada quando deletar um usuário no form
    if (this.enabledFormEditOneUser) {
      this.userService.delete(user.id).subscribe(successResponse => {
        this.sucessDialog = true;
        this.enabledFormEditOneUser = false;
      }, error => {
        //colocar o dialog de erro
        console.log(error);
      });
    } else {
      //Esta condiçao será chamada quando deletar um usuário no data grid
      this.userService.delete(this.selectedUser.id).subscribe(sucessResponse => {
        this.sucessDialog = true;
        this.closeDeleteUser();
        this.getUsers();
      }, error => {
        this.errorDialog = true;
      });
    }

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
