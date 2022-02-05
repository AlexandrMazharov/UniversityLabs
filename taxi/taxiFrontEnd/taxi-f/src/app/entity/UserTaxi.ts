import {Role} from './Role';

export class UserTaxi {

  userId: number;
  userEmail: string;
  userPassword: string;
  userFirstName: string;
  userLastName: string;
  userSecondName: string;
  userRating: number;
  userRoles: Role[];

  constructor(id: number, email: string, password: string, first_name: string, last_name: string, second_name: string, rating: number, roles: Role[]) {    this.userId = id;
    this.userEmail = email;
    this.userPassword = password;
    this.userFirstName = first_name;
    this.userLastName = last_name;
    this.userSecondName = second_name;
    this.userRating = rating;
    this.userRoles = roles;
  }
}
