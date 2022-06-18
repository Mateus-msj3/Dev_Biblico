import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {User} from 'src/app/shared/models/user';
import {AuthService} from 'src/app/shared/services/auth.service';
import {UserService} from "../../shared/services/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username?: string;

  password?: string;

  email?: string;

  loginSucess?: string;

  errors?: string[];

  display: boolean = false;

  user: User = new User();

  sucessDialog: boolean = false;

  errorDialog: boolean = false;

  constructor(private router: Router, private authService: AuthService, private userService: UserService,) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.authService.tryLogin(this.username, this.password).subscribe(response => {
        const access_token = JSON.stringify(response);
        localStorage.setItem('access_token', access_token);
        this.router.navigate(['/admin']);

        //Melhorar depois
        let userLogged = this.authService.getUserAutheticated();

        if (userLogged === 'admin') {
          console.log(userLogged)
          this.router.navigate(['/admin']);
        }else {
          this.router.navigate(['/devotional']);
        }

    }, errorResponse =>{
        this.errors = ['Usuário ou senhas incorretos(s). ']
      } );

  }

  saveUser() {
    if (!this.user.id) {
      this.userService.save(this.user).subscribe(sucessResponse => {
        this.sucessDialog = true;
        this.clearFormNewUser();
      }, errorResponse => {
        this.errorDialog = true;
      });
    }

  }

  clearFormNewUser() {
    this.user.username = "";
    this.user.email = "";
    this.user.password = "";
  }

  openNewUser() {
    this.display = true;
    this.router.navigate(['login/sub']);
  }

  closeNewUser() {
    this.display = false;
  }

  closeDialogSuccess() {
    this.sucessDialog = false;
    this.display = false;
  }

  closeDialogError() {
    this.errorDialog = false;
  }

}
