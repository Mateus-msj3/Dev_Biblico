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

  // getUser():Observable<User[]> {
  //   return this.http.get<User[]>(this.apiURL);
  // }

  getUser(){
    return this.http.get<User[]>(this.apiURL)
      .toPromise()
      .then(res => <User[]> res)
      .then(data => { return data });
  }

  getUserById(id: number | undefined): Observable<User> {
    return this.http.get<User>(this.apiURL +`/${id}`);
  }

  getUserByEmail(email: string | undefined): Observable<User> {
    return this.http.get<User>(this.apiURL + `/email/${email}`);
  }

  // getUserByUsername(username: string | undefined): Observable<User[]> {
  //   return this.http.get<User[]>(this.apiURL + `/username/${username}`);
  // }

  getUserByUsername(username: string | undefined){
    return this.http.get<User[]>(this.apiURL + `/username/${username}`)
      .toPromise()
      .then(res => <any[]> res)
      .then(data => { return data });
  }

  save(user: User): Observable<User> {
    return this.http.post<User>(this.apiURL, user);
  }

  update(user: User): Observable<User> {
    return this.http.put<User>(this.apiURL +`/${user.id}`, user);
  }

  delete(id: number | undefined): Observable<any> {
    return this.http.delete<any>(this.apiURL +`/${id}`);
  }
 }
