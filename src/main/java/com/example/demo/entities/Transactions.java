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
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaction_id;
    private String transactiontype;
    private String transferedto;
    private Long amount;
    @ManyToOne
    @JoinColumn(name="account_id")
    private Accounts acount;
    public Accounts getAcount() {
        return acount;
    }
    public void setAcount(Accounts acount) {
        this.acount = acount;
    }
    @ManyToOne
    @JoinColumn(name="atm_id")
    private Atms atm;

    public Integer getTransaction_id() {
        return transaction_id;
    }
    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }
    public String getTransactiontype() {
        return transactiontype;
    }
    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }
    public String getTransferedto() {
        return transferedto;
    }
    public void setTransferedto(String transferedto) {
        this.transferedto = transferedto;
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
}
