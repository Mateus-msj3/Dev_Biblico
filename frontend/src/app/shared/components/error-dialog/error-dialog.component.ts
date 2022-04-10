import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error-dialog',
  templateUrl: './error-dialog.component.html',
  styleUrls: ['./error-dialog.component.css']
})
export class ErrorDialogComponent implements OnInit {
  errorDialog: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  closeDialogError() {

  }
}
