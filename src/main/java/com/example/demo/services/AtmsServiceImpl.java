package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Atms;
import com.example.demo.repositories.AtmsRepository;

@Service
public class AtmsServiceImpl implements AtmsService{

    @Autowired
    private AtmsRepository atmsRepository;
    
    @Override
    public List<Atms> Get() {
        return atmsRepository.findAll();
    }

    @Override
    public Atms Get(Integer id) {
        return atmsRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Atms model) {
        atmsRepository.save(model);
        return atmsRepository.findById(model.getAtm_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        atmsRepository.deleteById(id);
        return !atmsRepository.findById(id).isPresent();
    }
    
}
