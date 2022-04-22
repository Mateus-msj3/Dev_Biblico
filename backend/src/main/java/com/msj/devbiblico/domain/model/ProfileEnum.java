package com.msj.devbiblico.domain.model;

public enum ProfileEnum {

    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private int code;

    private String name;

    ProfileEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static ProfileEnum toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (ProfileEnum role : ProfileEnum.values()) {
            if (code.equals(role.getCode())) {
                return role;
            }
        }

        throw new IllegalArgumentException("Code invalid: "  + code);
    }

}
