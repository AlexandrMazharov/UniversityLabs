import {UserTaxi} from './UserTaxi';

export class Trip {
  trip_id: number;
  trip_adress_a: string;
  trip_adress_b: string;
  trip_price: number;
  trip_feedback: string;
  trip_user: UserTaxi;
  trip_dirver: UserTaxi;

  constructor(trip_id: number, trip_adress_a: string, trip_adress_b: string, price: number, trip_feedback: string, trip_user: UserTaxi, trip_dirver: UserTaxi) {
    this.trip_id = trip_id;
    this.trip_adress_a = trip_adress_a;
    this.trip_adress_b = trip_adress_b;
    this.trip_price = price;
    this.trip_feedback = trip_feedback;
    this.trip_user = trip_user;
    this.trip_dirver = trip_dirver;
  }
}
