import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {UsedCar} from '../../../../entity/UsedCar';
import {UsedCarService} from '../../../../services/used-car/used-car.service';
import {UserTaxiService} from '../../../../services/user-taxi/user-taxi.service';
import {UserTaxi} from '../../../../entity/UserTaxi';
import {Car} from '../../../../entity/Car';
import {CarsService} from '../../../../services/cars/cars.service';

@Component({
  selector: 'app-view-used-car-table',
  templateUrl: './view-used-car-table.component.html',
  styleUrls: ['./view-used-car-table.component.scss']
})
export class ViewUsedCarTableComponent implements OnInit {


  //типы шаблонов
  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;


  editedUsedCar: UsedCar;
  usedCar: Array<UsedCar>;
  users: Array<UserTaxi>;
  cars: Array<Car>;
  isNewRecord: boolean;
  statusMessage: string;

  constructor(private  serv: UsedCarService, private  serverUser: UserTaxiService, private serverCar: CarsService) {

    this.usedCar = new Array<UsedCar>();
    this.users = new Array<UserTaxi>();
    this.cars = new Array<Car>();

  }

  ngOnInit() {
    this.loadUsedCar();
    this.loadUsers();
    this.laordCars();

  }

//загрузка юзеров
  public loadUsers() {
    this.serverUser.getUserTaxi().subscribe((data: UserTaxi[]) => {
      console.log(data);
      this.users = data;
    });
  }

  //загрузка машин
  private laordCars() {
    this.serverCar.getCars().subscribe((data: Car[]) => {
      this.cars = data;
      console.log(this.cars);
    });
  }

  //загрузка
  private loadUsedCar() {
    this.serv.getUsedCar().subscribe((data: UsedCar[]) => {
      this.usedCar = data;
      console.log(this.usedCar);
    });
  }

  // добавление пользователя
  addUsedCar() {
    this.editedUsedCar = new UsedCar(0, Object(), Object(), '', '');
    this.usedCar.push(this.editedUsedCar);
    this.isNewRecord = true;
  }

  // редактирование пользователя
  editUsedCar(usedCar: UsedCar) {
    console.log(usedCar);
    this.editedUsedCar = new UsedCar(
      usedCar.used_car__id, usedCar.used_car__driver, usedCar.used_car__car,
      usedCar.used_car__with, usedCar.used_car__form);
  }

  // загружаем один из двух шаблонов
  loadTemplate(usedCar: UsedCar) {
    if (this.editedUsedCar && this.editedUsedCar.used_car__id === usedCar.used_car__id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  // сохраняем пользователя
  saveUsedCar() {
    if (this.isNewRecord) {
      // добавляем пользователя
      this.serv.createUsedCar(this.editedUsedCar).subscribe(data => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadUsedCar();
      });
      this.isNewRecord = false;
      this.editedUsedCar = null;
    } else {
      // изменяем пользователя

      this.serv.updateUsedCar(this.editedUsedCar).subscribe(data => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadUsedCar();
      });
      this.editedUsedCar = null;
    }
  }
changeDateFormat(){
  this.editedUsedCar.used_car__form = new Date(this.editedUsedCar.used_car__form).toDateString();
  this.editedUsedCar.used_car__with = new Date(this.editedUsedCar.used_car__form).toDateString();

}
  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.usedCar.pop();
      this.isNewRecord = false;
    }
    this.editedUsedCar = null;
  }

  // удаление пользователя
  deleteUsedCar(usedCar: UsedCar) {
    this.serv.deleteUsedCar(usedCar?.used_car__id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadUsedCar();
    });
  }


  picker2Change() {
    console.log("click");

    this.editedUsedCar.used_car__form = new Date(this.editedUsedCar.used_car__form).toDateString();
    console.log(this.editedUsedCar.used_car__form);
  }
}
