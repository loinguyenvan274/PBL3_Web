package com.pbl.flightapp.appExc;

public class LoginFailedException extends Exception {
    private String why;
    public LoginFailedException(String message, Throwable cause, String why) {
        super(message, cause);
        this.why = why;
    }

    public String getWhy() {
        return why;
    }
}
