package com.dailycodework.exceptions;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptionHandler {

    @ExceptionHandler(value = { AccessDeniedException.class })
    public ResponseEntity<String> HandleAccessDeniedException(AccessDeniedException ex) {
        String message = "Access denied";
        return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
    }
}
