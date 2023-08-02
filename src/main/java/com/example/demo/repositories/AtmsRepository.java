package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Atms;

public interface AtmsRepository {
    List<Atms> Get();
    Atms Get(Integer atm_id);
    Boolean Post(Atms atm);
    Boolean Put(Atms atm);
    Boolean Delete(Integer bank_id);
}
