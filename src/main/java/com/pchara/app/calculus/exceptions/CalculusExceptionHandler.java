package com.pchara.app.calculus.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CalculusExceptionHandler {
    
    private Logger logger = LoggerFactory.getLogger(CalculusExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<Object> handleCalculusException(RuntimeException e) {
        CalculusExceptionResponse response = new CalculusExceptionResponse(e.getMessage());
        logger.error(response.message, e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
