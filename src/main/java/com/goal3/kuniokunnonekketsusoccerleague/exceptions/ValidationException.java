package com.goal3.kuniokunnonekketsusoccerleague.exceptions;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

    private Map<String, String> errors = new HashMap<>(); //ключ - название поля, значение - сообщение об ошибке

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public ValidationException() {
    }

    public ValidationException(String fieldName, String errorMessage) {
        put(fieldName, errorMessage);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ValidationException setStatus(HttpStatus status) {
        this.status = status;

        return this;
    }

    public Map<String, String> get() {
        return errors;
    }

    public void put(String fieldName, String errorMessage) {
        this.errors.put(fieldName, errorMessage);
    }

    public void throwExceptionIfIsNotEmpty() {
        if (!this.errors.isEmpty()) {
            throw this;
        }
    }
}
