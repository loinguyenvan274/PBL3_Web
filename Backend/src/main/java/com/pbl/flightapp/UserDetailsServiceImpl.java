package com.pbl.flightapp;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pbl.flightapp.Model.Account;
import com.pbl.flightapp.Service.AccountService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountService.getByEmail(username);
        if (account.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> authorities = account.get().getRole().getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name())) 
                .collect(Collectors.toSet());
        return new User(account.get().getEmail(), account.get().getPassword(), authorities);
    }
}
