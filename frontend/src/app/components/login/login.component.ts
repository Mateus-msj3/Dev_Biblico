import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username?: string;
  password?: string;
  email?: string;
  loginError?: boolean;
  signing?: boolean;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.router.navigate(['/home']);
    console.log(`User: ${this.username}, Password: ${this.password}`)
  }

  prepareSigning(event: any) {
    event.preventDefault();
    this.signing = true;
  }

  cancelSigning(event: any) {
    this.signing = false;
  }


}
