package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Accounts;
import com.example.demo.repositories.AccountsRepository;

@Service
public class AccountsServiceImpl implements AccountsService{

    @Autowired
    private AccountsRepository accountRepo;
    @Override
    public List<Accounts> Get() {
        return accountRepo.findAll();
    }

    @Override
    public Accounts Get(String id) {
        return accountRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Accounts model) {
        accountRepo.save(model);
        return accountRepo.findById(model.getAccount_id()).isPresent();
    }

    @Override
    public Boolean Delete(String id) {
        accountRepo.deleteById(id);
        return !accountRepo.findById(id).isPresent();    
    }
    
}
