package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Atms;
import com.example.demo.services.AtmsServiceImpl;

public class AtmsController {
    AtmsServiceImpl atmsService = new AtmsServiceImpl();

    public List<Atms> Get(){
        return atmsService.Get();
    }

    public String Post(Atms atm){
        Boolean result = atmsService.Post(atm);
        if (result == true) {
            return "Insert Success!";
        }else{
            return "Insert Unsuccess!";
        }
    }

    public Atms Get(Integer atm_id){
        Atms result  = atmsService.Get(atm_id);
        return result;
    }

    public String Delete(Integer atm_id){
        Boolean result = atmsService.Delete(atm_id);
        if (result == true) {
            return "Delete Success!";
        } else {
            return "Delete Unsuccess!";
        }
    }

    public String Put(Atms atm){
        Boolean result = atmsService.Put(atm);
        if (result == true) {
            return "Success!";
        } else {
            return "Unsuccess!";
        }
    }
}
