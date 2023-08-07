package com.example.demo.services;

import com.example.demo.entities.Customers;
import com.example.demo.services.generic.GenericService;

public interface CustomersService extends GenericService<Customers,String>{
    Customers GetByFullname(String fullname);
}
