package com.pchara.app.calculus.exceptions;

public class CalculusExceptionResponse {
    private String message;
    public CalculusExceptionResponse(String message) {
        this.setMessage(message);
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
