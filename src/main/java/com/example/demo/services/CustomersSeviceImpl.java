package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customers;
import com.example.demo.repositories.CustomersRepository;

@Service
public class CustomersSeviceImpl implements CustomersService{

    @Autowired
    private CustomersRepository customerRepo;
    @Override
    public List<Customers> Get() {
        return customerRepo.findAll();
    }

    @Override
    public Customers Get(String account_id) {
        return customerRepo.findById(account_id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Customers model) {
        customerRepo.save(model);
        return customerRepo.findById(model.getAccount_id()).isPresent();
    }

    @Override
    public Boolean Delete(String account) {
        customerRepo.deleteById(account);
        return !customerRepo.findById(account).isPresent();
    }
}
