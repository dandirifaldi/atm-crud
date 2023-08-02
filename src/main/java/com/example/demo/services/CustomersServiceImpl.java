package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Customers;
import com.example.demo.repositories.CustomersRepositoryImpl;
import com.example.demo.tools.DBConnections;

public class CustomersServiceImpl implements CustomersService{
    DBConnections connection = new DBConnections();
    CustomersRepositoryImpl customerRepo = new CustomersRepositoryImpl(connection.getConnection());
    
    @Override
    public List<Customers> Get() {
        return customerRepo.Get();
    }

    @Override
    public Customers Get(Accounts account) {
        return customerRepo.Get(account);
    }

    @Override
    public Boolean Post(Customers customer) {
        return customerRepo.Post(customer);
    }

    @Override
    public Boolean Put(Customers customer) {
        return customerRepo.Put(customer);
    }

    @Override
    public Boolean Delete(Accounts account) {
        return customerRepo.Delete(account);
    }
    
}
