package com.example.demo.dto;

public class RegisterRequest {
    private String account_id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String pin;
    private Long balance;
    private String bank_id;
    private String card_id;
    
    public String getCard_id() {
        return card_id;
    }
    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
    public String getAccount_id() {
        return account_id;
    }
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public Long getBalance() {
        return balance;
    }
    public void setBalance(Long balance) {
        this.balance = balance;
    }
    public String getBank_id() {
        return bank_id;
    }
    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }
}
