package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Banks;
import com.example.demo.repositories.BanksRepositoryImpl;
import com.example.demo.tools.DBConnections;

public class BanksServiceImpl implements BanksService {
    DBConnections connection = new DBConnections();
    BanksRepositoryImpl bankRepository = new BanksRepositoryImpl(connection.getConnection());
    // public BanksServiceImpl(Connection conn){
        // this.conn=conn;
    // }

    @Override
    public List<Banks> getAll() {
        return bankRepository.getAll();
    }

    @Override
    public Banks Get(String bank_id) {
        return bankRepository.Get(bank_id);
    }

    @Override
    public Boolean Post(Banks bank) {
        return bankRepository.Post(bank);
    }

    @Override
    public Boolean Put(Banks bank) {
        return bankRepository.Put(bank);
    }

    @Override
    public Boolean Delete(String bank_id){
        return bankRepository.Delete(bank_id);
    }
    
}
