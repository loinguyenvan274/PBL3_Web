package com.pbl.flightapp.DTO;

import java.sql.Timestamp;
import com.pbl.flightapp.Model.Role;

public class AccountDTO {
    private int idAccount;
    private String email;
    private String password;
    private Timestamp createdAt;
    private Role role;

    public AccountDTO() {
    }

    public AccountDTO(int idAccount, String email, String password, Timestamp createdAt,
            Role role) {
        this.idAccount = idAccount;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
