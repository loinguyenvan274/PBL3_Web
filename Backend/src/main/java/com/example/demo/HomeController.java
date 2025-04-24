package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    static int count = 0;

    @PostMapping("/submit")
    public String receiveData(@RequestParam String userInput) {

        System.out.println("Dữ liệu nhận được: " + userInput + " " + (count++));
        return "Dữ liệu đã nhận: " + userInput;
    }

    @GetMapping("/data_from_server/{out}")
    public Map<String, String> sent_from_server(@PathVariable String out) {
        String a = "hello";
        String b = "project started";
        Map<String, String> response = new HashMap<>();
        response.put("message1", "This is signal from Server: " + a);
        response.put("message2", "This is signal from Server: " + b);
        return response;
    }
}
