import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Trip} from '../../entity/Trip';

@Injectable({
  providedIn: 'root'
})
export class TripService {

  private url = 'http://localhost:8080/trip';

  constructor(private http: HttpClient) {
  }

  getTrips() {

    return this.http.get(this.url);
  }

  createTrip(trip: Trip) {
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(this.url, JSON.stringify(trip), {headers: myHeaders});
  }

  updateTrip(trip: Trip) {
    console.log(trip);
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    let updUrl = 'http://localhost:8080/trip/upd/';
    return this.http.put(updUrl + trip.trip_id, JSON.stringify(trip), {headers: myHeaders});
  }

  deleteTrip(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

}
