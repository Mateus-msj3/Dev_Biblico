import {roleEnum} from "./roleEnum";

export class User {

    id?: number;

    username?: string;

    email?: string;

    password?: string;

    roles: Set<number> = new Set<number>();
}
