import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProfileService {

  constructor(private http: HttpClient) { }

  addProfile(data: any){
    return this.http.post('http://localhost:8080/userProfiles/addUserProfile', data);
  }

  getUser(id: number){
    let options = {
      headers: new HttpHeaders()
          
          .set("Access-Control-Allow-Origin", "*")
          .set('Access-Control-Allow-Methods', 'PUT, GET, POST, DELETE, OPTIONS')
          .set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, Access-Control-Allow-Credentials")
          .set("Access-Control-Allow-Credentials", "true")

  }

    return this.http.get(`http://localhost:8080/userProfiles/getAllUserProfiles/${id}`, options);
  }

  updateUser(data: any){
    return this.http.put('http://localhost:8080/userProfiles/updateUserProfile', data);
  }

  deleteUser(id: number): Observable<any>{

    return this.http.delete(`http://localhost:8080/userProfiles/deleteUserProfile/${id}`);
  }



}
