import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Role} from '../../entity/Role';

@Injectable()

export class RoleService {
  private url = 'http://localhost:8080/roles';

  constructor(private http: HttpClient) {

  }

  getRoles() {

    return this.http.get(this.url);
  }

  createRole(role: Role) {
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(this.url, JSON.stringify(role), {headers: myHeaders});
  }

  updateRole(role: Role) {
    console.log(role);
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    let updUrl = 'http://localhost:8080/roles/upd/';
    return this.http.put(updUrl + role.roleId, JSON.stringify(role), {headers: myHeaders});
  }

  deleteRole(id: number) {
    return this.http.delete(this.url + '/' + id);
  }

}

