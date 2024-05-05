import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProfileService {

  private url = 'http://localhost:8080/userProfiles'

  constructor(private http: HttpClient) { }

  addProfile(data: any){
    return this.http.post(`${this.url}/addUserProfile`, data);
  }

  getUser(id: number){
    return this.http.get(`${this.url}/getAllUserProfiles/${id}`);
  }

  updateUser(data: any){
    return this.http.put(`${this.url}/updateUserProfile`, data);
  }

  deleteUser(id: number): Observable<any>{

    return this.http.delete(`${this.url}/deleteUserProfile/${id}`);
  }

}
