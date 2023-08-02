package com.example.demo.entities;

public class Accounts {
    private String account_id, pin; 
    private Banks bank_id;
    private Long balance;

    public Banks getBank_id() {
        return bank_id;
    }
    public void setBank_id(Banks bank_id) {
        this.bank_id = bank_id;
    }

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
    public Long getBalance() {
        return balance;
    }
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Accounts(){
        System.out.println("This Account Construct");
    }

}
