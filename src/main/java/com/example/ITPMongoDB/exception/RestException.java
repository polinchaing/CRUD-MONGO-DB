package com.example.ITPMongoDB.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleRestException(ResponseStatusException e) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", e.getStatusCode().value());
        error.put("message", e.getMessage());
        error.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.status(e.getStatusCode())
                .body(error);
    }


}
