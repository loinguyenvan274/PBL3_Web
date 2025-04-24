package com.example.demo.Account;

import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;

import com.example.demo.Model.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserAccount {
    @Id
    private String username;
    private String password;
    @OneToOne
    @JoinColumn(name = "Id_Card", referencedColumnName = "Id_Card", nullable = false)
    private Customer custommer;

    public UserAccount() {
    }

    public UserAccount(String username, String password, Customer custommer) {
        this.username = username;
        this.password = password;
        this.custommer = custommer;
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

    public Customer getCustommer() {
        return custommer;
    }
}
// Tạo tk -> Nhậpf UserAccount bao gồm customer
// đăng nhập -> kiểm tra username và password có đúng không
