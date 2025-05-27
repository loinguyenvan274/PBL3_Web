package com.pbl.flightapp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pbl.flightapp.appExc.AccountException;
import com.pbl.flightapp.appExc.PermissionException;




@RestControllerAdvice
public class GlobalExceptionHandler {

    // Bắt các lỗi cụ thể trước (ưu tiên)
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<?> handleAccountException(AccountException e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        error.put("code", e.getCode());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Bắt tất cả các lỗi còn lại
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Lỗi không xác định: " + e.getMessage());
        error.put("code", "UNKNOWN_ERROR");

        // In log hoặc stacktrace để tiện debug
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(PermissionException.class)
    public ResponseEntity<?> handlePermissionException(PermissionException e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        error.put("code", "PERMISSION_DENIED");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
}
