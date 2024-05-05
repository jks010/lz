import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = 'http://localhost:8080/users'
  constructor(private http: HttpClient) { }

  addUser(data: any){
    return this.http.post(`${this.url}/addUser`, data);
  }

  getUser(){
    return this.http.get(`${this.url}/getAllUsers`);
  }

  updateUser(data: any){
    return this.http.put(`${this.url}/updateUser`, data);
  }

  deleteUser(id: number): Observable<any>{

    return this.http.delete(`${this.url}/deleteUser/${id}`);
  }

}
