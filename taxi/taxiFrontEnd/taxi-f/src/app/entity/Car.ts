export class Car {
  car_id: number;
  car_number: string;
  car_model: string;
  car_color: string;
  car_type: string;


  constructor(car_id: number, car_number: string, car_model: string, car_color: string, car_type: string) {
    this.car_id = car_id;
    this.car_number = car_number;
    this.car_model = car_model;
    this.car_color = car_color;
    this.car_type = car_type;
  }
}
