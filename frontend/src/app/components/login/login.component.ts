import { Role } from './../../shared/models/role';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/shared/models/user';
import { AuthService } from 'src/app/shared/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username?: string;

  password?: string;

  email?: string;

  role?: Role;

  // loginError?: boolean;

  loginSucess?: string;

  signing?: boolean;

  errors?: string[];

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    debugger
    this.authService
      .tryLogin(this.username, this.password).subscribe(response => {
        const access_token = JSON.stringify(response);
        localStorage.setItem('access_token', access_token)
        this.router.navigate(['/admin']);

      }, errorResponse =>{
        this.errors = ['Usuário ou senhas incorretos(s). ']
      } )

  }

  prepareSigning(event: any) {

    event.preventDefault();
    this.signing = true;

  }

  cancelSigning(event: any) {

    this.signing = false;

  }

  register() {
    debugger
    const user: User = new User();
    user.username = this.username;
    user.email = this.email;
    user.password = this.password;
    user.role = this.role

    this.authService.save(user).subscribe(response => {
      console.log('Sucesso');
      this.loginSucess = 'Cadastro realizado com sucesso! Efetue o login.';
      this.signing = false;
      this.username = '';
      this.password = '';
      this.errors = [];
    }, errorResponse => {
      this.loginSucess = '';
      this.errors = errorResponse.error.errors
    })

  }

  login() {
  }


}
