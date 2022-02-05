import {UserTaxi} from './UserTaxi';
import {Car} from './Car';

export class UsedCar {

  used_car__id: number;
  used_car__driver: UserTaxi;
  used_car__car: Car;
  used_car__with: string;
  used_car__form: string;


  constructor(used_car__id: number, used_car__driver: UserTaxi, used_car__car: Car, used_car__with: string, used_car__form: string) {
    this.used_car__id = used_car__id;
    this.used_car__driver = used_car__driver;
    this.used_car__car = used_car__car;
    this.used_car__with = used_car__with;
    this.used_car__form = used_car__form;
  }
}
