package com.pbl.flightapp.appExc;

public class UserException extends Exception {
    private String code;

    public UserException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
