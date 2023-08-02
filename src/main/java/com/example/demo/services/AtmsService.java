package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Atms;

public interface AtmsService {
    List<Atms> Get();
    Atms Get(Integer atm_id);
    Boolean Post(Atms atm);
    Boolean Put(Atms atm);
    Boolean Delete(Integer atm_id);
}
