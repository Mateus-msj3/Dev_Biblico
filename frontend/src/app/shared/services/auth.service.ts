import { User } from './../models/user';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) {

   }

   save(user: User): Observable<any> {
     return this.http.post<User>(`${this.url}/`, user);
   }
}
