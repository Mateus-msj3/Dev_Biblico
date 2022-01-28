package com.msj.devbiblico.domain.exception;

public class ObjectInUseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectInUseException(String mensagem) {
        super(mensagem);
    }

}