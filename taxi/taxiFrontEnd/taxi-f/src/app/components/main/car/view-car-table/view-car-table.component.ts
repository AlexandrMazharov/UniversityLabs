import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Car} from '../../../../entity/Car';
import {CarsService} from '../../../../services/cars/cars.service';
import {UserService} from '../../../../services/user/user-service.service';

@Component({
  selector: 'app-view-car-table',
  templateUrl: './view-car-table.component.html',
  styleUrls: ['./view-car-table.component.scss']
})
export class ViewCarTableComponent implements OnInit {

  //типы шаблонов
  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedCar: Car;
  cars: Array<Car>;
  isNewRecord: boolean;
  statusMessage: string;

  constructor(private  serv: CarsService, private  userService: UserService) {
    this.cars = new Array<Car>();
  }

  ngOnInit() {
    // this.userService.getUserBoard().subscribe((data) => {
    //   console.log(data);
    // });
    // this.userService.getUserBoard().subscribe(
    //   data => {
    //     console.log(data);
    //   },
    //   err => {
    //     console.log( JSON.parse(err.error).message);
    //   }
    // );

    this.loadCars();
  }

  //загрузка
  private loadCars() {
    this.serv.getCars().subscribe((data: Car[]) => {
      console.log(data);
      this.cars = data;
      console.log(this.cars);
    });
  }

  // добавление пользователя
  addCar() {
    this.editedCar = new Car(0, '', '', '', '');
    this.cars.push(this.editedCar);
    this.isNewRecord = true;
  }

  // редактирование пользователя
  editCar(car: Car) {
    console.log('click edit car');
    console.log(car);
    this.editedCar = new Car(car.car_id, car.car_number,
      car.car_model, car.car_color, car.car_type
    )
    ;
  }

  // загружаем один из двух шаблонов
  loadTemplate(car: Car) {
    if (this.editedCar && this.editedCar.car_id === car.car_id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  // сохраняем пользователя
  saveCar() {
    if (this.isNewRecord) {
      // добавляем пользователя
      this.serv.createCar(this.editedCar).subscribe(data => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadCars();
      });
      this.isNewRecord = false;
      this.editedCar = null;
    } else {
      // изменяем пользователя
      this.serv.updateCar(this.editedCar).subscribe(data => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadCars();
      });
      this.editedCar = null;
    }
  }

  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.cars.pop();
      this.isNewRecord = false;
    }
    this.editedCar = null;
  }

  // удаление пользователя
  deleteCar(car: Car) {
    this.serv.deleteCar(car?.car_id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadCars();
    });
  }


}
