package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_m_accounts")
public class Accounts {
    @Id
    @Column(name="account_id")
    private String account_id;
    private String pin;
    @ManyToOne
    @JoinColumn(name="bank_id")
    private Banks bank_id;
    private Long balance;
    @OneToOne(mappedBy = "account")
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Customers customer;

    @OneToMany(mappedBy = "acount")
    @JsonIgnore
    private List<Transactions> transaction;

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

    public Banks getBank_id() {
        return bank_id;
    }

    public void setBank_id(Banks bank_id) {
        this.bank_id = bank_id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }  

}
