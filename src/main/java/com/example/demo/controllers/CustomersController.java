package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Customers;
import com.example.demo.services.CustomersServiceImpl;

public class CustomersController {
    CustomersServiceImpl customerService = new CustomersServiceImpl();

    public List<Customers> Get(){
        return customerService.Get();
    }

    public String Post(Customers customer){
        Boolean result = customerService.Post(customer);
        if (result == true) {
            return "Insert Success!";
        }else{
            return "Insert Unsuccess!";
        }
    }

    public Customers Get(Accounts account){
        Customers result  = customerService.Get(account);
        return result;
    }

    public String Delete(Accounts account){
        Boolean result = customerService.Delete(account);
        if (result == true) {
            return "Delete Success!";
        } else {
            return "Delete Unsuccess!";
        }
    }

    public String Put(Customers customers){
        Boolean result = customerService.Put(customers);
        if (result == true) {
            return "Success!";
        } else {
            return "Unsuccess!";
        }
    }
}
