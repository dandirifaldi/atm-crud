package com.example.demo.entities;

public class Banks {
    private String bank_id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public Banks(){
        System.out.println("Banks Data");
    }
    
    public Banks(String bank_id, String name){
        this.bank_id=bank_id;
        this.name=name;
    }

    public Banks(String bank_id){
        this.bank_id=bank_id;
    }
}
