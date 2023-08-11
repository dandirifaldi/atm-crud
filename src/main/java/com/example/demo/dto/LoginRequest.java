package com.example.demo.dto;

public class LoginRequest {
    private String account_id;
    private String pin;
    public String getAccount_id() {
        return account_id;
    }
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
}
