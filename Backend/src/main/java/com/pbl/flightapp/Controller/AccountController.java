package com.pbl.flightapp.Controller;

import com.pbl.flightapp.DTO.AccountDTO;
import com.pbl.flightapp.Model.Account;
import com.pbl.flightapp.Service.AccountService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
 

    // Lấy tất cả account dạng DTO
    @GetMapping("/all_account_by_email")
//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<AccountDTO> getAllAccountByEmail(@RequestParam String email, @RequestParam String requestCreatedAt) {
        Timestamp createdAt = null;
        if (requestCreatedAt != null && !requestCreatedAt.isEmpty()) {
            createdAt = Timestamp.valueOf(requestCreatedAt); // cần đúng định dạng: yyyy-MM-dd HH:mm:ss
        }
        return accountService.getAllAccountByEmail(email,createdAt);
    }

    // Lấy account theo id
    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    // Tạo account mới
    @PostMapping
    public Account createAccount(@RequestBody AccountRequest accountRequest) {
        return accountService.createAccount(new Account(accountRequest.getEmail(), accountRequest.getPassword()), accountRequest.getRoleId());
    }

   static class AccountRequest{
        private String email;
        private String password;
        private long roleId;
        public String getEmail() {
            return email;}
        public String getPassword() {
            return password;}
        public long getRoleId() {
            return roleId;}
        public void setEmail(String email) {
            this.email = email;}
        public void setPassword(String password) {
            this.password = password;}
        public void setRoleId(long roleId) {
            this.roleId = roleId;}
    }

    // Cập nhật account theo id
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable int id, @RequestBody AccountRequest accountRequest) {
        return accountService.updateAccount(id, new Account(accountRequest.getEmail(), accountRequest.getPassword()), accountRequest.getRoleId());
    }

    // Xóa account theo id
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id) {
        boolean deleted = accountService.deleteAccount(id);
        return deleted ? "Deleted successfully" : "Account not found";
    }
}