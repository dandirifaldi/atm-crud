package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="tb_m_banks")
public class Banks {
    @Id
    private String bank_id;
    private String name;

    @OneToMany(mappedBy = "bank_id")
    @JsonIgnore
    private List<Atms> atms;
    
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
        System.out.println("Initialize Banks Data...");
    }
    
    public Banks(String bank_id, String name){
        this.bank_id=bank_id;
        this.name=name;
    }

    public Banks(String bank_id){
        this.bank_id=bank_id;
    }
}
