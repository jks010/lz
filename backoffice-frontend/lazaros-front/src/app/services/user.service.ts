import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  addUser(data: any){
    return this.http.post('http://localhost:8080/users/addUser', data);
  }

  getUser(){
    let options = {
      headers: new HttpHeaders()
          
          .set("Access-Control-Allow-Origin", "*")
          .set('Access-Control-Allow-Methods', 'PUT, GET, POST, DELETE, OPTIONS')
          .set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, Access-Control-Allow-Credentials")
          .set("Access-Control-Allow-Credentials", "true")

  }

    return this.http.get('http://localhost:8080/users/getAllUsers', options);
  }

  updateUser(data: any){
    return this.http.put('http://localhost:8080/users/updateUser', data);
  }

  deleteUser(id: number): Observable<any>{

    return this.http.delete(`http://localhost:8080/users/deleteUser/${id}`);
  }

}
