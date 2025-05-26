package com.pbl.flightapp.appExc;

public class AccountException extends Exception {
    String code;
    public AccountException(String message, String code) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
