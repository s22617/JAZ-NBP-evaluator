package com.s22617.nbpevaluator.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.ConnectException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {HttpClientErrorException.BadRequest.class})
    public ResponseEntity<String> handleBadRequestException(HttpClientErrorException.BadRequest e) {
        return ResponseEntity.status(400).body("Exception message: " + e.getLocalizedMessage());
    }

    @ExceptionHandler(value = {HttpClientErrorException.NotFound.class})
    public ResponseEntity<String> handleNotFoundException(HttpClientErrorException.NotFound e) {
        return ResponseEntity.status(404).body("Exception message: " + e.getLocalizedMessage());
    }

    @ExceptionHandler(value = {ConnectException.class})
    public ResponseEntity<String> handleConnectException(ConnectException e) {
        return ResponseEntity.status(400).body("Exception message: " + e.getLocalizedMessage());
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.status(400).body("Exception message: " + e.getLocalizedMessage());
    }
}
