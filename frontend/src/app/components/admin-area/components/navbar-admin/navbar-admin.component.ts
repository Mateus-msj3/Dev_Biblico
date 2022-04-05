import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../shared/services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar-admin',
  templateUrl: './navbar-admin.component.html',
  styleUrls: ['./navbar-admin.component.css']
})
export class NavbarAdminComponent implements OnInit {

  userLogged?: string;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.userLogged = this.authService.getUserAutheticated();
  }

  logout() {
    this.authService.endSession();
    this.router.navigate(['/login']);
  }

}
