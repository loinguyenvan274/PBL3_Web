package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserAccService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/userAcc")
public class UserAccController {
    UserAccService userAccService;

    @Autowired
    public UserAccController(UserAccService userAccService) {
        this.userAccService = userAccService;
    }

    // @GetMapping("/login")
    // public boolean checkLogin(@RequestParam String username, @RequestParam String
    // password) {

    // return userAccService.checkLogin(username, password);
    // }

    // @GetMapping("/register")
    // public boolean register(String username, String password) {
    // return userAccService.register(username, password);
    // }
}

// tk, mk -> get api -> service -> check return
// đăng nhập : nếu đúng -> tạo session