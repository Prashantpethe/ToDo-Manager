package com.prashant.todo.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceFoundException extends RuntimeException{

    private String message;
    private HttpStatus status;

    public ResourceFoundException(String message,HttpStatus status) {
    super(message);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ResourceFoundException() {
    }
}
