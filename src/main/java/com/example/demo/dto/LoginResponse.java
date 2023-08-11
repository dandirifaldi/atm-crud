package com.example.demo.dto;

public class LoginResponse {
    private String account_id;
    private String pin;
    private String cardtype;

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

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public LoginResponse() {}

    public LoginResponse(String account_id, String pin,String cardtype) {
        this.account_id=account_id;
        this.pin=pin;
        this.cardtype=cardtype;
    }
}
