import { Component, OnInit } from '@angular/core';
import {ConfirmationService} from "primeng/api";
import {UserService} from "../../../../shared/services/user.service";
import {User} from "../../../../shared/models/user";

@Component({
  selector: 'app-user-area',
  templateUrl: './user-area.component.html',
  styleUrls: ['./user-area.component.css']
})
export class UserAreaComponent implements OnInit {

  user: User = new User() ;

  teste: any = [{
    nome: "Teste",
    avatar: "Avatar",
    email: "teste@email.com",
    perfil: 'ADMIN'
  }];
  selectedProducts: any;
  productDialog: any;
  submitted: boolean = true;
  statuses: any;
  perfil: any;
  profiles: any = [];
  selectedProfile: any;
  value1: any;

  display: boolean = false;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  saveUser() {
    this.userService.save(this.user).subscribe(response => {
      console.log(response);
    })
  }

  openNewUser() {
    this.display = true;
  }

  editProduct(product: any) {

  }

  deleteProduct(product: any) {

  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {
    console.log('teste')
  }
}
