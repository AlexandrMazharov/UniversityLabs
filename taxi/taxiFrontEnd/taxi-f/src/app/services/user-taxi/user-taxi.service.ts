import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserTaxi} from '../../entity/UserTaxi';
import {catchError} from "rxjs/operators";
import {throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserTaxiService {
  private url = 'http://localhost:8080/usertaxi';

  constructor(private http: HttpClient) {
  }

  getUserTaxi() {

    return this.http.get(this.url);
  }

  createUserTaxi(userTaxi: UserTaxi) {
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(this.url, JSON.stringify(userTaxi), {headers: myHeaders}) ;
  }

  updateUserTaxi(userTaxi: UserTaxi) {
    console.log(userTaxi);
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    let updUrl = 'http://localhost:8080/usertaxi/upd/';
    return this.http.put(updUrl + userTaxi.userId, JSON.stringify(userTaxi), {headers: myHeaders});
  }

  deleteUserTaxi(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

}
