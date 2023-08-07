package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_m_atms")
public class Atms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer atm_id;
    private String location;
    @ManyToOne
    @JoinColumn(name="bank_id")
    private Banks bank_id;
    public Long atm_balance;
    
    @OneToMany(mappedBy = "atm")
    @JsonIgnore
    private List<Transaction> transaction;

    public Banks getBank_id() {
        return bank_id;
    }
    public void setBank_id(Banks bank_id) {
        this.bank_id = bank_id;
    }
    public Long getAtm_balance() {
        return atm_balance;
    }
    public void setAtm_balance(Long atm_balance) {
        this.atm_balance = atm_balance;
    }
    public Integer getAtm_id() {
        return atm_id;
    }
    public void setAtm_id(Integer atm_id) {
        this.atm_id = atm_id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Atms(){
        System.out.println("Initialize Atms Data...");
    }
    public Atms(Integer atm_id, String location, Banks bank_id, Long atm_balance){
        this.atm_id=atm_id;
        this.location=location;
        this.bank_id=bank_id;
        this.atm_balance=atm_balance;
    }
    public Atms( String location, Banks bank_id, Long atm_balance){
        this.location=location;
        this.bank_id=bank_id;
        this.atm_balance=atm_balance;
    }
    public Atms(Integer atm_id){
        this.atm_id=atm_id;
    }
}
