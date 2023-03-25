package com.prashant.todo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException npe)
    {
        logger.info("Its Null pointer exception from global handler");
        return new ResponseEntity<>(npe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceFoundException re)
    {
       // logger.info("Its Resource not found exception");
        logger.error("Error{}",re.getMessage());
        ExceptionResponse exceptionRes = new ExceptionResponse();
        exceptionRes.setMessage(re.getMessage());
        exceptionRes.setStatus(HttpStatus.NOT_FOUND);
        exceptionRes.setSuccess(false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionRes);

    }
}
