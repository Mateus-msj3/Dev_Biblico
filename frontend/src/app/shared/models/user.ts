import { Role } from './role';
export class User {

  // constructor(role: Role) {
  //   this.role.id = 1;
  // }

    id?: number;

    username?: string;

    email?: string;

    password?: string;

    role?: Role = new Role(1);
}
