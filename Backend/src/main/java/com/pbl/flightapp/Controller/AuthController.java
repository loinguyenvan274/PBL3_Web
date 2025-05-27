package com.pbl.flightapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pbl.flightapp.Model.Account;
import com.pbl.flightapp.appExc.LoginFailedException;
import com.pbl.flightapp.webConfig.JwtService;

import jakarta.servlet.http.HttpServletResponse;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/custom-login")
    public String loginPage() {
        return "login"; // tên file login.html trong thư mục templates (nếu dùng Thymeleaf)
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account,
            HttpServletResponse response) {
        String jwtToken = null;
        try {
            jwtToken = jwtService.generateToken(account.getUsername(), account.getPassword());
        } catch (LoginFailedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        // Tạo cookie
        ResponseCookie cookie = ResponseCookie.from("token", jwtToken)
                .httpOnly(true)
                .secure(false)
                .sameSite("Lax")
                .path("/")
                .maxAge(Duration.ofHours(1))
                .build();
        // Đưa cookie vào response
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        // Trả response (tùy bạn)
        return ResponseEntity.ok(jwtService.getPermissions(jwtToken));
    }   

    class UserInfoResponse {
        private String notification;
        private List<String> permissions;

        public UserInfoResponse(String notification, List<String> permissions) {
            this.notification = notification;
            this.permissions = permissions;
        }

        // Getters
        public String getNotification() {
            return notification;
        }

        public List<String> getPermissions() {
            return permissions;
        }
    }
}