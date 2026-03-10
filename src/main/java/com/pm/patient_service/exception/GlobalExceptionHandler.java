/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pm.patient_service.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author guyma
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorObjectResponse> handleTokenNotFound(EmailAlreadyExistsException ex) {
        ErrorObjectResponse errorObjectResponse = new ErrorObjectResponse();
        errorObjectResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorObjectResponse.setMessage(errorObjectResponse.getMessage());
        errorObjectResponse.setTimestamp(new Date());
        return new ResponseEntity<>(errorObjectResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorObjectResponse> handleTokenNotFound(PatientNotFoundException ex) {
        ErrorObjectResponse errorObjectResponse = new ErrorObjectResponse();
        errorObjectResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorObjectResponse.setMessage(errorObjectResponse.getMessage());
        errorObjectResponse.setTimestamp(new Date());
        return new ResponseEntity<>(errorObjectResponse, HttpStatus.NOT_FOUND);
    }
}
