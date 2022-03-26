import { Component, OnInit } from '@angular/core';
import {ConfirmationService} from "primeng/api";

@Component({
  selector: 'app-user-area',
  templateUrl: './user-area.component.html',
  styleUrls: ['./user-area.component.css']
})
export class UserAreaComponent implements OnInit {

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

  constructor(confirmationService: ConfirmationService) { }

  ngOnInit(): void {
  }

  openNewUser() {
    this.teste = {};
    this.submitted = false;
    this.productDialog = true;
  }

  editProduct(product: any) {

  }

  deleteProduct(product: any) {

  }

  hideDialog() {
    debugger
    console.log('teste')
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {

  }
}
