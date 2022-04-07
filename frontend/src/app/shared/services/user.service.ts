import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiURL: string = environment.apiURLBase + "/api/users";

  constructor(private http: HttpClient) {

  }

  save(user: User): Observable<User> {
    return this.http.post<User>(this.apiURL, user);
  }
}
