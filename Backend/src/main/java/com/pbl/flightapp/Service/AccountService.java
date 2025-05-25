package com.pbl.flightapp.Service;

import com.pbl.flightapp.DTO.AccountDTO;
import com.pbl.flightapp.Model.Account;
import com.pbl.flightapp.Model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pbl.flightapp.Repository.AccountRepo;
import com.pbl.flightapp.Repository.RoleRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private RoleRepo roleRepo;

    // Lấy tất cả account
    public List<AccountDTO> getAllAccountByEmail(String email, Timestamp createdAt) {
        if(email!=null && email.isEmpty())
            email=null;
        return accountRepo.findAccountDTOs(email, createdAt);
    }

    // Tạo mới account
    @Transactional
    public Account createAccount(Account account, long roleId) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Role role = roleRepo.findById(roleId).orElse(null);
        if (role == null) {
            System.out.println("Role not found");
            throw new IllegalArgumentException("Role not found");
        }
        account.setRole(role);
        account.setPassword(bcrypt.encode(account.getPassword()));
        account.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return accountRepo.save(account);
    }

    // Lấy account theo id
    public Optional<Account> getAccountById(int id) {
        return accountRepo.findById(id);
    }

    public Optional<Account> getByEmail(String email) {
        return Optional.ofNullable(accountRepo.findByEmail(email));
    }

    // Cập nhật account
    public Account updateAccount(int id, Account updatedAccount, long roleId) {
        Role role = roleRepo.findById(roleId).orElse(null);
        if (role == null) {
            System.out.println("Role not found");
            throw new IllegalArgumentException("Role not found");
        }
        return accountRepo.findById(id).map(account -> {
            account.copyFrom(updatedAccount);
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            account.setPassword(bcrypt.encode(account.getPassword()));
            account.setRole(role);
            return accountRepo.save(account);
        }).orElse(null);
    }

    // Xóa account
    public boolean deleteAccount(int id) {
        if (accountRepo.existsById(id)) {
            accountRepo.deleteById(id);
            return true;
        }
        return false;
    }

    //
    // public int Login(String username, String password) {
    // Account userAccount = AccountRepo.findByUsernameAndPassword(username,
    // password);
    // if (userAccount != null) {
    // if (userAccount.getRole().equals("admin")) {
    // return 1; // Admin
    // } else {
    // return 2; // User
    // }
    // } else {
    // return 0; // Error
    // }
    // }

    // public boolean checkLogin(String username, String password) {
    // HttpSession session = request.get; // Assuming you have a session object
    // available
    // if (username == "admin" && password == "admin") {
    // session.setAttribute("Role", "admin");
    // return true;
    // } else {
    // Account userAccount = AccountRepo.findByUsernameAndPassword(username,
    // password);
    // if (userAccount != null) {
    // session.setAttribute("Role", "user");
    // return true;
    // } else {
    // return false;
    // }
    // }
    // }
}
