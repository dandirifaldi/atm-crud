package com.example.demo.entities;

public class Atms {
    private Integer atm_id;
    public Long atmBalance;
    private String location;
    private Banks bank;

    public Integer getAtm_id() {
        return atm_id;
    }
    public void setAtm_id(Integer atm_id) {
        this.atm_id = atm_id;
    }
    public Long getAtmBalance() {
        return atmBalance;
    }
    public void setAtmBalance(Long atmBalance) {
        this.atmBalance = atmBalance;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Banks getBank() {
        return bank;
    }
    public void setBank(Banks bank) {
        this.bank = bank;
    }

    public Atms(){
        System.out.println("Atms Data");
    }
    public Atms(Integer atm_id, String location, Banks bank, Long atmBalance){
        this.atm_id=atm_id;
        this.location=location;
        this.bank=bank;
        this.atmBalance=atmBalance;
    }
    public Atms( String location, Banks bank, Long atmBalance){
        this.location=location;
        this.bank=bank;
        this.atmBalance=atmBalance;
    }
    public Atms(Integer atm_id){
        this.atm_id=atm_id;
    }
}
