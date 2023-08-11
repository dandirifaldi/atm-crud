package com.example.demo.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.handler.Response;
import com.example.demo.services.AccountsService;

@RestController
@RequestMapping("api")
public class UserRestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountsService accountService;
    @PostMapping("user/login")
    public ResponseEntity<Object> login( @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getAccount_id(), loginRequest.getPin()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()) {
            return Response.generateResponse(HttpStatus.OK, "Login Successful");
        }
        return Response.generateResponse(HttpStatus.UNAUTHORIZED, "Login Gagal");
        
    }
    @PostMapping("user/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest){
        Boolean result = accountService.register(registerRequest);
        if (result) {
            return Response.generateResponse(HttpStatus.OK, "Data Berhasil disimpan");
        }
        return Response.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Data Gagal disimpan");
    }

    // @PostMapping("user/forgot")
    // public ResponseEntity<Object> forgotPassword(@RequestBody Login login){
    //     Boolean result = accountService.forgotPassword(login);
    //     if (result) {
    //         return Response.generateResponse(HttpStatus.OK, "Password Berhasil diubah");
    //     }
    //     return Response.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Password Gagal Diubah");  
    // }

    // @PostMapping("profile/changePassword")
    // public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
    //     Boolean result = accountService.changePassword(changePasswordRequest);
    //     if (result) {
    //         return Response.generateResponse(HttpStatus.OK, "Password Berhasil diubah");
    //     }
    //     return Response.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Password Gagal Diubah");   
    // }
    
}
