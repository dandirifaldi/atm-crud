package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Banks;
import com.example.demo.repositories.BanksRepository;

@Service
public class BanksServiceImpl implements BanksService {

    @Autowired
    private BanksRepository banksRepository;
    
    @Override
    public List<Banks> Get() {
        return banksRepository.findAll();
    }

    @Override
    public Banks Get(String id) {
        return banksRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Banks model) {
        banksRepository.save(model);
        return banksRepository.findById(model.getBank_id()).isPresent();
    }

    @Override
    public Boolean Delete(String id) {
        banksRepository.deleteById(id);
        return !banksRepository.findById(id).isPresent();
    }
    
}
