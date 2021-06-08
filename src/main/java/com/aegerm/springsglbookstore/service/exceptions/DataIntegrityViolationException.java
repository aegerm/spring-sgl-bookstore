package com.aegerm.springsglbookstore.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 2269190743296091755L;

    public DataIntegrityViolationException() {
    }

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
