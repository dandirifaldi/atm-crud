package com.example.demo.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.AccountsRepository;
import com.example.demo.entities.Accounts;


@Service
public class MyUserDetails implements UserDetails, UserDetailsService {
    @Autowired
    private AccountsRepository accountRepository;
    private String account_id;
    private String pin;
    private GrantedAuthority authority;

    public MyUserDetails() {}

    public MyUserDetails(Accounts account) {
        this.account_id = account.getAccount_id();
        this.pin = account.getPin();
        this.authority = new SimpleGrantedAuthority(account.getCard().getCardtype());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(authority);
        return grantedAuthority;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts data = accountRepository.login(username);
        return new MyUserDetails(data);
    }

    @Override
    public String getPassword() {
        return pin;
    }

    @Override
    public String getUsername() {
        return account_id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}