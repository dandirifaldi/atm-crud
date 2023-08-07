package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_tr_transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaction_id;
    private Long amount;
    private String transferedto;
    private String transactiontype;
    @ManyToOne
    @JoinColumn(name="atm_id")
    private Atms atm;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Accounts accounts;

    public String getTransferedto() {
        return transferedto;
    }
    public void setTransferedto(String transferedto) {
        this.transferedto = transferedto;
    }
    public String getTransactiontype() {
        return transactiontype;
    }
    public void setTransaction_type(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Atms getAtm() {
        return atm;
    }
    public void setAtm(Atms atm) {
        this.atm = atm;
    }
    public Accounts getAccount() {
        return accounts;
    }
    public void setAccount(Accounts accounts) {
        this.accounts = accounts;
    }
    public Transaction(){
        System.out.println("Initialize Transactions..");
    }
    public Transaction( Accounts accounts, String transactiontype, String transferedto, Long amount, Atms atm){
        this.accounts=accounts;
        this.transactiontype=transactiontype;
        this.transferedto=transferedto;
        this.amount=amount;
        this.atm=atm;
    }
}
