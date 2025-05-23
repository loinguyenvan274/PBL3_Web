package com.pbl.flightapp.Controller;

import com.pbl.flightapp.DTO.AccountDTO;
import com.pbl.flightapp.Model.Account;
import com.pbl.flightapp.Service.AccountService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<AccountDTO> getAllAccountByEmail(@RequestParam String email) {
        return accountService.getAllAccountByEmail(email);
    }

    // Lấy account theo id
    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    // Tạo account mới
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // Cập nhật account theo id
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable int id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    // Xóa account theo id
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id) {
        boolean deleted = accountService.deleteAccount(id);
        return deleted ? "Deleted successfully" : "Account not found";
    }
}