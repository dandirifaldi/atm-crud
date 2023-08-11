package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cards;
import com.example.demo.repositories.CardsRepository;

@Service
public class CardsServiceImpl implements CardsService{
    @Autowired
    private CardsRepository cardRepo;
    @Override
    public List<Cards> Get() {
        return cardRepo.findAll();
    }

    @Override
    public Cards Get(String id) {
        return cardRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Cards model) {
        cardRepo.save(model);
        return cardRepo.findById(model.getCard_id()).isPresent();
    }

    @Override
    public Boolean Delete(String id) {
        cardRepo.deleteById(id);
        return !cardRepo.findById(id).isPresent();
    }
    
}
