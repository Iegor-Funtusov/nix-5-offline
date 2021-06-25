import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { UserModel } from '../model/user-model';
import { api } from '../const';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = api + 'users/'

  constructor(private http: HttpClient) { }

  create(user: UserModel): Observable<any> {
    return this.http.post(this.url, user);
  }

  update(user: UserModel, id: number): Observable<any> {
    return this.http.put(this.url + id, user);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(this.url + id);
  }

  findById(id: number): Observable<any> {
    return this.http.get(this.url + id);
  }

  findAll(): Observable<any> {
    return this.http.get(this.url);
  }
}
