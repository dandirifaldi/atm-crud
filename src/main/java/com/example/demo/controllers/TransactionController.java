package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Transactions;
import com.example.demo.services.AccountsService;
import com.example.demo.services.AtmsService;
import com.example.demo.services.TransactionsService;

@Controller
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private AtmsService atmService;
    @Autowired
    private AccountsService accountService;
    @Autowired
    private TransactionsService transactionsService;

    @GetMapping
    public String index(Model model) {
        // model.addAttribute("customers", cusService.Get());
        // model.addAttribute("accounts", accService.Get());
        model.addAttribute("transactions", transactionsService.Get());
        
        return "transaction/index";
    }

    @GetMapping(value = "form")
    public String form(Model model) {
        model.addAttribute("atmsList", atmService.Get());
        model.addAttribute("accountsList", accountService.Get());
        model.addAttribute("transaction", new Transactions());
        return "transaction/form";
    }


    @PostMapping("save")
    public String submit(Transactions transaction){
        Boolean result2= transactionsService.Save(transaction);
        if (result2) {
            return "redirect:/transaction";
        } else{
            return "transaction:/form";
        }
    }
}
