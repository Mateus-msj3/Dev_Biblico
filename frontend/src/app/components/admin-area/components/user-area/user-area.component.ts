import { Component, OnInit } from '@angular/core';
import {ConfirmationService} from "primeng/api";

@Component({
  selector: 'app-user-area',
  templateUrl: './user-area.component.html',
  styleUrls: ['./user-area.component.css']
})
export class UserAreaComponent implements OnInit {
  // teste: any = []
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

  constructor(confirmationService: ConfirmationService) { }

  ngOnInit(): void {
  }

  openNewUser() {
    this.display = true;
    // console.log('teste')
    // this.teste = {};
    // this.submitted = false;
    // this.productDialog = true;
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
