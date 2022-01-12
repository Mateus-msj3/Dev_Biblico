package com.msj.devbiblico.domain.exception;

public class UserCreatedException extends RuntimeException {

    public UserCreatedException(String username) {
        super("User already registered");
    }
}
