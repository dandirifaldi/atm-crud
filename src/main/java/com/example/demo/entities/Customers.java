package com.example.demo.entities;

public class Customers {
    private Accounts account;
    private Banks bank;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Long balance;
    private String pin;
    
    public Banks getBank() {
        return bank;
    }

    public void setBank_id(Banks bank) {
        this.bank = bank;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Customers(){
        System.out.println("Customers");
    }
    public Customers(Accounts account, String fullName, String phoneNumber, String email, String pin, Long balance, Banks bank){
        this.account=account;
        this.fullName=fullName;
        this.phoneNumber=phoneNumber;
        this.pin=pin;
        this.balance=balance;
        this.email = email;
        this.bank=bank;
    }
    public Customers(Accounts account, String fullName, String phoneNumber, String email){
        this.account=account;
        this.fullName=fullName;
        this.phoneNumber=phoneNumber;
        this.email = email;
    }

    public Customers(Accounts account){
        this.account=account;
    }
}
