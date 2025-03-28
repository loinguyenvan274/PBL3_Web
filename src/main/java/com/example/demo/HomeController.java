package com.example.demo;

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
    public String sent_from_server(@PathVariable String out) {
        return "This is signal from Server" + out;
    }
}
