package com.example.demo.services;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entities.Accounts;
import com.example.demo.services.generic.GenericService;

public interface AccountsService extends GenericService<Accounts,String>{
    public Boolean register(RegisterRequest registerRequest);
    // public Boolean changePassword(ChangePasswordRequest changePasswordRequest);
    // public Boolean isTruePassword(ChangePasswordRequest changePasswordRequest);
    // public Boolean forgotPassword(Login login);
}
