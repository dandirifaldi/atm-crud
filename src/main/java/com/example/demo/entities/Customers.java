package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_m_customers")
public class Customers {
    @Id
    @Column(name = "account_id")
    private String account_id;
    
    private String fullname;
    private String phonenumber;
    private String email;
    
    @MapsId
    @OneToOne
    @JoinColumn(name="account_id")
    private Accounts account;

    public Accounts getAccount() {
        return account;
    }
    public void setAccount(Accounts account) {
        this.account = account;
    }
    public String getAccount_id() {
        return account_id;
    }
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
    
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Customers(){
        System.out.println("Initialize Customers...");
    }
    public Customers(String account, String fullname, String phonenumber, String email, String pin, Long balance, Banks bank){
        this.account_id=account;
        this.fullname=fullname;
        this.phonenumber=phonenumber;
        this.email = email;
    }
    public Customers(String account, String fullname, String phonenumber, String email){
        this.account_id=account;
        this.fullname=fullname;
        this.phonenumber=phonenumber;
        this.email = email;
    }

    public Customers(String account){
        this.account_id=account;
    }
}
