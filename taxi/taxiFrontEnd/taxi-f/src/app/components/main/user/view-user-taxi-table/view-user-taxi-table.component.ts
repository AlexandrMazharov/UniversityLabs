import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {UserTaxi} from '../../../../entity/UserTaxi';
import {UserTaxiService} from '../../../../services/user-taxi/user-taxi.service';
import {Role} from '../../../../entity/Role';
import {RoleService} from '../../../../services/roles/role.service';

@Component({
  selector: 'app-view-user-taxi-table',
  templateUrl: './view-user-taxi-table.component.html',
  styleUrls: ['./view-user-taxi-table.component.scss']
})
export class ViewUserTaxiTableComponent implements OnInit {


  //типы шаблонов
  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedUserTaxi: UserTaxi;
  userTaxi: Array<UserTaxi>;
  userRole: Array<Role>;
  isNewRecord: boolean;
  statusMessage: string;

  constructor(private  serv: UserTaxiService, private servRole: RoleService) {
    this.userTaxi = new Array<UserTaxi>();
    this.userRole = new Array<Role>();
  }

  ngOnInit() {
    this.loadUserTaxi();
    this.loadRoles();
  }

  //загрузка
  private loadUserTaxi() {
    this.serv.getUserTaxi().subscribe((data: UserTaxi[]) => {
      console.log(data);
      this.userTaxi = data;
      console.log(this.userTaxi);
    });
  }

  //загрузка ролей
  private loadRoles() {
    this.servRole.getRoles().subscribe((data: Role[]) => {
      console.log(data);
      this.userRole = data;
      console.log(this.userRole);
    });

  }

  // добавление пользователя
  addUserTaxi() {
    this.editedUserTaxi = new UserTaxi(0, '', '', '', '', '', 0, []);
    this.userTaxi.push(this.editedUserTaxi);
    this.isNewRecord = true;
  }

  // редактирование пользователя
  editUserTaxi(userTaxi: UserTaxi) {
    console.log('click edit car');
    console.log(userTaxi);
    this.editedUserTaxi = new UserTaxi(userTaxi.userId, userTaxi.userEmail,
      userTaxi.userPassword, userTaxi.userFirstName, userTaxi.userLastName,
      userTaxi.userSecondName, userTaxi.userRating, userTaxi.userRoles
    )
    ;
  }

  // загружаем один из двух шаблонов
  loadTemplate(userTaxi: UserTaxi) {
    if (this.editedUserTaxi && this.editedUserTaxi.userId === userTaxi.userId) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  // сохраняем пользователя
  saveUserTaxi() {
    if (this.isNewRecord) {
      // добавляем пользователя
      this.serv.createUserTaxi(this.editedUserTaxi).subscribe(data => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadUserTaxi();
      }, error => {
        this.statusMessage = 'Ошибка при добавлении нового пользователя. Пользователь не добавлен!';
        this.loadUserTaxi();
      });
      this.isNewRecord = false;
      this.editedUserTaxi = null;
    } else {
      // изменяем пользователя
      this.serv.updateUserTaxi(this.editedUserTaxi).subscribe(data => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadUserTaxi();
      }, error => {
        this.statusMessage = 'Ошибка при изменении пользователя. Пользователь не изменен!';
        this.loadUserTaxi();
      });
      this.editedUserTaxi = null;
    }
  }

  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.userTaxi.pop();
      this.isNewRecord = false;
    }
    this.editedUserTaxi = null;
  }

  // удаление пользователя
  deleteUserTaxi(userTaxi: UserTaxi) {
    this.serv.deleteUserTaxi(userTaxi?.userId).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadUserTaxi();
    });
  }


}
