package com.pbl.flightapp.Controller;    

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthController {

    @GetMapping("/custom-login")
    public String loginPage() {
        return "login"; // tên file login.html trong thư mục templates (nếu dùng Thymeleaf)
    }

    @GetMapping("/home")
    public UserInfoResponse home() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String notification = "Đăng nhập thành công!";
        List<String> permissions = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new UserInfoResponse(notification, permissions);
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