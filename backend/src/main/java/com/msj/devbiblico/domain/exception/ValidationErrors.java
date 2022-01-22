package com.msj.devbiblico.domain.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ValidationErrors {

    @Getter
    private List<String> errors;

    public ValidationErrors(List<String> errors) {
        this.errors = errors;
    }

    public ValidationErrors(String message) {
        this.errors = Arrays.asList(message);
    }
}
