package com.msj.devbiblico.domain.exception;

public class EmailCreatedException extends RuntimeException {

    public EmailCreatedException(String email) {
        super("Email already registered");
    }
}
