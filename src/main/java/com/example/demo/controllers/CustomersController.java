package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Customers;
import com.example.demo.services.AccountsService;
import com.example.demo.services.BanksService;
import com.example.demo.services.CustomersService;

@Controller
@RequestMapping("customer")
public class CustomersController {
    @Autowired
    private AccountsService accService;
    @Autowired
    private BanksService banksService;
    @Autowired
    private CustomersService cusService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("customers", cusService.Get());
        model.addAttribute("accounts", accService.Get());
        return "customer/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(@PathVariable(required = false) String id, Model model) {
        // List<Banks> bankList = banksService.Get();
        if (id != null) {
            model.addAttribute("customer", cusService.Get(id));
            model.addAttribute("banksList", banksService.Get());
            model.addAttribute("accountsList", accService.Get(id));
        } else {
            model.addAttribute("banksList", banksService.Get());
            model.addAttribute("customer", new Customers());
            // model.addAttribute("account", new Accounts());
        }
        return "customer/form";
    }


    @PostMapping("save")
    public String submit(Customers customer){
        Boolean result2= cusService.Save(customer);
        if (result2) {
            return "redirect:/customer";
        } else{
            return "customer:/form";
        }
    }


    // delete
    // customer/delete/1
    @PostMapping("delete/{id}")
    public String accountDelete(@PathVariable(required =true) String id){
        cusService.Delete(id);
        accService.Delete(id);
        return "redirect:/customer";
    }
}
