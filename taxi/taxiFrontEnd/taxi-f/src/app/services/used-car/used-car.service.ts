import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UsedCar} from '../../entity/UsedCar';

@Injectable({
  providedIn: 'root'
})
export class UsedCarService {
  private url = 'http://localhost:8080/usedcars';

  constructor(private http: HttpClient) {
  }

  getUsedCar() {
    return this.http.get(this.url);
  }

  createUsedCar(usedCar: UsedCar) {
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(this.url, JSON.stringify(usedCar), {headers: myHeaders});
  }

  updateUsedCar(usedCar: UsedCar) {
    console.log(usedCar);
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    let updUrl = 'http://localhost:8080/usedcars/upd/';
    return this.http.put(updUrl + usedCar.used_car__id, JSON.stringify(usedCar), {headers: myHeaders});
  }

  deleteUsedCar(id: number) {
    return this.http.delete(this.url + '/' + id);
  }
}
