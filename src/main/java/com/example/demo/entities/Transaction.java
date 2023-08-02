package com.example.demo.entities;

public class Transaction {
    private Long amount;
    private String transferedTo;
    private String transactionType;
    private Atms atm;
    private Accounts account;

    public Atms getAtm() {
        return atm;
    }
    public void setAtm(Atms atm) {
        this.atm = atm;
    }
    public Accounts getAccount() {
        return account;
    }
    public void setAccount(Accounts account) {
        this.account = account;
    }
    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public String getTransferedTo() {
        return transferedTo;
    }
    public void setTransferedTo(String transferedTo) {
        this.transferedTo = transferedTo;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Transaction(){
        System.out.println("Transactions");
    }
    public Transaction( Accounts account, String transactionType, String transferedTo, Long amount, Atms atm){
        this.account=account;
        this.transactionType=transactionType;
        this.transferedTo=transferedTo;
        this.amount=amount;
        this.atm=atm;
    }
}
