package com.goal3.kuniokunnonekketsusoccerleague.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<Object> handleValidationException(ValidationException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ex.get());
    }

    //данный метод будет срабатывать, если исключение не было обработано ни одним другим методом в данном классе
//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<Object> handleException(Exception ex) {
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ex.getMessage());
//    }
}
