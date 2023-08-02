package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Banks;
import com.example.demo.services.BanksServiceImpl;

public class BanksController {
    BanksServiceImpl banksService = new BanksServiceImpl();

    public List<Banks> getAll(){
        return banksService.getAll();
    }

    public String Post(Banks bank){
        Boolean result = banksService.Post(bank);
        if (result == true) {
            return "Insert Success!";
        }else{
            return "Insert Unsuccess!";
        }
    }

    public Banks Get(String bank_id){
        Banks result  = banksService.Get(bank_id);
        return result;
    }

    public String Delete(String bank_id){
        Boolean result = banksService.Delete(bank_id);
        if (result == true) {
            return "Delete Success!";
        } else {
            return "Delete Unsuccess!";
        }
    }
    public String Put(Banks bank){
        Boolean result = banksService.Put(bank);
        if (result == true) {
            return "Success!";
        } else {
            return "Unsuccess!";
        }
    }

}
