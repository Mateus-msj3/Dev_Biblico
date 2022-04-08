package com.msj.devbiblico.domain.model;

public enum RoleEnum {

    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private int code;

    private String name;

    RoleEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static RoleEnum toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (RoleEnum role : RoleEnum.values()) {
            if (code.equals(role.getCode())) {
                return role;
            }
        }

        throw new IllegalArgumentException("Code invalid: "  + code);
    }

}
