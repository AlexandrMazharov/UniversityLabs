import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Trip} from '../../../../entity/Trip';
import {TripService} from '../../../../services/trip/trip.service';
import {UserTaxi} from '../../../../entity/UserTaxi';
import {Car} from '../../../../entity/Car';
import {UserTaxiService} from '../../../../services/user-taxi/user-taxi.service';
import {CarsService} from '../../../../services/cars/cars.service';

@Component({
  selector: 'app-view-trip-table',
  templateUrl: './view-trip-table.component.html',
  styleUrls: ['./view-trip-table.component.scss']
})
export class ViewTripTableComponent implements OnInit {


  //типы шаблонов
  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedTrip: Trip;
  trips: Array<Trip>;
  isNewRecord: boolean;
  statusMessage: string;

  users: Array<UserTaxi>;


  constructor(private  serv: TripService, private  serverUser: UserTaxiService) {
    this.trips = new Array<Trip>();
    this.users = new Array<UserTaxi>();

  }

  ngOnInit() {
    this.loadTrips();
    this.loadUsers();
  }

//загрузка юзеров
  public loadUsers() {
    this.serverUser.getUserTaxi().subscribe((data: UserTaxi[]) => {
      console.log(data);
      this.users = data;
    });
  }

  //загрузка
  private loadTrips() {
    this.serv.getTrips().subscribe((data: Trip[]) => {
      console.log(data);
      this.trips = data;
      console.log('trips');
      console.log(this.trips);
    });
  }

  // добавление пользователя
  addTrip() {
    this.editedTrip = new Trip(0, '', '',
      0, '', Object(), Object());
    this.trips.push(this.editedTrip);
    this.isNewRecord = true;
  }

  // редактирование пользователя
  editTrip(trip: Trip) {
    console.log('click edit car');
    console.log(trip);
    this.editedTrip = new Trip(trip.trip_id, trip.trip_adress_a,
      trip.trip_adress_b, trip.trip_price,
      trip.trip_feedback, trip.trip_user, trip.trip_dirver
    );

  }

  // загружаем один из двух шаблонов
  loadTemplate(trip: Trip) {
    if (this.editedTrip && this.editedTrip.trip_id === trip.trip_id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  // сохраняем пользователя
  saveTrip() {
    if (this.isNewRecord) {
      // добавляем пользователя
      this.serv.createTrip(this.editedTrip).subscribe(data => {
        console.log(data);
        this.statusMessage = 'Данные успешно добавлены',
          this.loadTrips();
      });
      this.isNewRecord = false;
      this.editedTrip = null;
    } else {
      // изменяем пользователя
      this.serv.updateTrip(this.editedTrip).subscribe(data => {
        console.log(data);
        this.statusMessage = 'Данные успешно обновлены',
          this.loadTrips();
      });
      this.editedTrip = null;
    }
  }

  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.trips.pop();
      this.isNewRecord = false;
    }
    this.editedTrip = null;
  }

  // удаление пользователя
  deleteTrip(trip: Trip) {
    this.serv.deleteTrip(trip?.trip_id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadTrips();
    });
  }


}
