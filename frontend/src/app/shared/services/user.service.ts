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

  getUser():Observable<User[]> {
    return this.http.get<User[]>(this.apiURL);
  }

  getUserById(id: number | undefined): Observable<User> {
    return this.http.get<User>(this.apiURL +`/${id}`);
  }

  getUserByEmail(email: string | undefined): Observable<User> {
    return this.http.get<User>(this.apiURL + `/email/${email}`)
  }

  save(user: User): Observable<User> {
    return this.http.post<User>(this.apiURL, user);
  }

  update(user: User): Observable<User> {
    return this.http.put<User>(this.apiURL +`/${user.id}`, user);
  }

  delete(user: User): Observable<any> {
    return this.http.delete<any>(this.apiURL +`/${user.id}`);
  }
 }
