package com.pbl.flightapp.appExc;

public class PermissionException extends RuntimeException {
    public PermissionException(String message) {
        super(message);
    }
}
