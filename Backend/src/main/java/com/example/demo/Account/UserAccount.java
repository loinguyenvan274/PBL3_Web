package com.example.demo.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
    @Id
    private String username;
    private String password;
    private String role;
    private String email;
    // @OneToOne
    // @JoinColumn(name = "Id_Card", referencedColumnName = "Id_Card", nullable =
    // false)
    // private Customer custommer;

    public UserAccount() {
    }

    public UserAccount(String username, String password, String email) {// mac dinh user
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = "user";
    }

    public UserAccount(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
// Tạo tk -> Nhậpf UserAccount bao gồm customer
// đăng nhập -> kiểm tra username và password có đúng không
