//package com.Vamshii.BloodProject.CustomExceptions;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(PersonNotFoundException.class)
//    public ResponseEntity<Map<String, Object>> handleEmployeeNotFoundException(PersonNotFoundException e) {
//        return createErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
//    }
//}