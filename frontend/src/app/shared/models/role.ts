import { RoleEnum } from './role.enum';
import { User } from "./user";

export class Role {

    id?: number;

    name?: RoleEnum;

    users?: User[];

}
