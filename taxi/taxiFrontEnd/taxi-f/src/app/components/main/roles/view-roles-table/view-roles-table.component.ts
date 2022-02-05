import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {RoleService} from '../../../../services/roles/role.service';
import {Role} from '../../../../entity/Role';

@Component({
  selector: 'app-view-roles-table',
  templateUrl: './view-roles-table.component.html',
  styleUrls: ['./view-roles-table.component.scss'],
  providers: [RoleService]
})
export class ViewRolesTableComponent implements OnInit {

  //типы шаблонов
  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedRole: Role;
  roles: Array<Role>;
  isNewRecord: boolean;
  statusMessage: string;

  constructor(private  serv: RoleService) {
    this.roles = new Array<Role>();
  }

  ngOnInit() {
    console.log("ngOnInit");
    this.loadRoles();
  }

  //загрузка
  private loadRoles() {
    this.serv.getRoles().subscribe((data: Role[]) => {
      console.log(data);
      this.roles = data;
      console.log(this.roles);
    });
  }

  // добавление
  addRole() {
    this.editedRole = new Role(0, '');
    this.roles.push(this.editedRole);
    this.isNewRecord = true;
  }

  // редактирование пользователя
  editRole(role: Role) {

    console.log('click edit role');
    console.log(role);
    this.editedRole = new Role(role.roleId, role.name);

  }

  // загружаем один из двух шаблонов
  loadTemplate(role: Role) {
    if (this.editedRole && this.editedRole.roleId === role.roleId) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  // сохраняем роль
  saveRole() {
    if (this.isNewRecord) {
      // добавляем
      this.serv.createRole(this.editedRole).subscribe(data => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadRoles();
      }, error => {
        this.statusMessage = 'Ошибка добавления роли! Роль не добавлена.',
          this.loadRoles();
      });
      this.isNewRecord = false;
      this.editedRole = null;
    } else {
      // изменяем
      this.serv.updateRole(this.editedRole).subscribe(data => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadRoles();
      }, error => {
        this.statusMessage = 'Ошибка изменения роли! Роль не изменена.',
          this.loadRoles();
      });
      this.editedRole = null;
    }
  }

  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.roles.pop();
      this.isNewRecord = false;
    }
    this.editedRole = null;
  }

  // удаление
  deleteRole(role: Role) {
    this.serv.deleteRole(role?.roleId).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadRoles();
    }, error => {
      this.statusMessage = 'Ошибка удаления роли! Роль не удалена.',
        this.loadRoles();
    });
  }

}
