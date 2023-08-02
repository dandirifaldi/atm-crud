package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Atms;
import com.example.demo.repositories.AtmsRepositoryImpl;
import com.example.demo.tools.DBConnections;

public class AtmsServiceImpl implements AtmsService{

    DBConnections connection = new DBConnections();
    AtmsRepositoryImpl atmRepository = new AtmsRepositoryImpl(connection.getConnection());

    @Override
    public List<Atms> Get() {
        return atmRepository.Get();
    }

    @Override
    public Atms Get(Integer atm_id) {
        return atmRepository.Get(atm_id);
    }

    @Override
    public Boolean Post(Atms atm) {
        return atmRepository.Post(atm);
    }

    @Override
    public Boolean Put(Atms atm) {
        return atmRepository.Put(atm);
    }

    @Override
    public Boolean Delete(Integer atm_id) {
        return atmRepository.Delete(atm_id);
    }
    
}
