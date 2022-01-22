package com.msj.devbiblico.api.exceptions;

import com.msj.devbiblico.domain.exception.EmailCreatedException;
import com.msj.devbiblico.domain.exception.ObjectNotFoundException;
import com.msj.devbiblico.domain.exception.UserCreatedException;
import com.msj.devbiblico.domain.exception.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

//@ControllerAdvice
@RestControllerAdvice
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrors handleValidationErrors(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return new ValidationErrors(messages);
    }


}
