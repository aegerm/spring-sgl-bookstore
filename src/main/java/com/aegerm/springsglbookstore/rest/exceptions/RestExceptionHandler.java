package com.aegerm.springsglbookstore.rest.exceptions;

import com.aegerm.springsglbookstore.service.exceptions.DataIntegrityViolationException;
import com.aegerm.springsglbookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<TypeError> objectNotFoundException(ObjectNotFoundException ex, ServletRequest request) {
        TypeError error = new TypeError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<TypeError> dataIntegrityViolationException(DataIntegrityViolationException ex, ServletRequest request) {
        TypeError error = new TypeError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<TypeError> validationError(MethodArgumentNotValidException ex, ServletRequest request) {
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos!");

        for (FieldError fieldMessage: ex.getBindingResult().getFieldErrors()) {
            error.addMessages(fieldMessage.getField(), fieldMessage.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
