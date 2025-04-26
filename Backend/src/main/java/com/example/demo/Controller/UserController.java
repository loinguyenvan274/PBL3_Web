package com.example.demo.Controller;

import java.time.LocalDate;
import com.example.demo.Model.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;
// import org.springframework.beans.factory.annotation.Autowired;
// import Controller;

@Controller
@RequestMapping("/user")
public class UserController {
    // Trang chủ , tìm chuyến, đặt vé
    @GetMapping("/")
    public String homePage() {
        return "redirect:/homeuser";
    }

    @GetMapping("/homeuser")
    // http://localhost:8080/user/homeuser
    public String homeUser(HttpSession session) {
        if (session.getAttribute("Role") != "user" || session.getAttribute("username") == null) {

            return "login"; // sử lí ở js để chuyến hướng về trang login
        }
        return "homeuser"; // sử lí ở js để chuyến hướng về trang homeuser
    }

    @GetMapping("/find_flight_u")
    public String findFlight(@RequestParam String from, @RequestParam String to,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
            HttpSession session) {
        return "redirect:/flight/find_flight?fromLocation=" + from + "&toLocation=" + to + "&departureDate="
                + departureDate;
    }

    @PostMapping("/book_ticket")
    // post lên các đối tượng : chuyến , vé , ghế , hành lý ,customer ,
    public ResponseEntity<?> bookTicket(@RequestBody Customer _customer, @RequestBody Flight _flight,
            @RequestBody Baggage _baggage, @RequestBody Seat _seat,
            HttpSession session) {
        // ********* Check session *********
        if (session.getAttribute("Role") != "user" || session.getAttribute("username") == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/login");
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }

        return ResponseEntity.ok("book ticket success"); // sử lí ở js để chuyến hướng về chuyến của tôi
    }
}
