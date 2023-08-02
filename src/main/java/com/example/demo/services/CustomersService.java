package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Customers;

public interface CustomersService {
    List<Customers> Get();
    Customers Get(Accounts account);
    Boolean Post(Customers customer);
    Boolean Put(Customers customer);
    Boolean Delete(Accounts account);
}
