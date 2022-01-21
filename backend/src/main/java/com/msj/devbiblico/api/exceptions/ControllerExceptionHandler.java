package com.msj.devbiblico.api.exceptions;

import com.msj.devbiblico.domain.exception.EmailCreatedException;
import com.msj.devbiblico.domain.exception.ObjectNotFoundException;
import com.msj.devbiblico.domain.exception.UserCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Email;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(UserCreatedException.class)
    public ResponseEntity<StandardError> userCreated(UserCreatedException e, HttpServletRequest request) {

        StandardError standardError = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(standardError);
    }

    @ExceptionHandler(EmailCreatedException.class)
    public ResponseEntity<StandardError> emailCreated(EmailCreatedException e, HttpServletRequest request) {

        StandardError standardError = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(standardError);
    }


}
