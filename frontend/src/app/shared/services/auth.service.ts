import { User } from './../models/user';
import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http'
import { Observable } from 'rxjs';
import {environment} from "../../../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiURL: string = environment.apiURLBase + "/api/users";

  tokenURL: string = environment.apiURLBase + environment.obterTokenURL;

  clientId: string = environment.clientId;

  clientSecret: string = environment.clientSecret;

  constructor(private http: HttpClient) {

   }

   save(user: User): Observable<any> {
     return this.http.post<User>(`${this.apiURL}/`, user);
   }


  tryLogin(username: any, password: any) : Observable<any> {

    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
      .set('grant_type', 'password');

    const headers = {
      'Authorization': 'Basic ' + btoa(`${this.clientId}:${this.clientSecret}`),
      'Content-Type': 'application/x-www-form-urlencoded',
    }

    return this.http.post(this.tokenURL, params.toString(), {headers});
  }
}
