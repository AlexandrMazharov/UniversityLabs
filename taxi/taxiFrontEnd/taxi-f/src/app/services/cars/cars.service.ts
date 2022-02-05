import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Car} from '../../entity/Car';

@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private url = 'http://localhost:8080/cars';

  constructor(private http: HttpClient) {
  }

  getCars() {

    return this.http.get(this.url);
  }

  createCar(car: Car) {
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(this.url, JSON.stringify(car), {headers: myHeaders});
  }

  updateCar(car: Car) {
    console.log(car);
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    let updUrl = 'http://localhost:8080/cars/upd/';
    return this.http.put(updUrl + car.car_id, JSON.stringify(car), {headers: myHeaders});
  }

  deleteCar(id: number) {
    return this.http.delete(this.url + '/' + id);
  }
}
