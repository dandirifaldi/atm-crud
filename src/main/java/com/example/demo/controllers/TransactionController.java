package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Transaction;
import com.example.demo.services.AtmsService;
import com.example.demo.services.TransactionsService;

@Controller
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private AtmsService atmService;
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
    public String form(@PathVariable(required = false) Accounts id, Model model) {
        model.addAttribute("atmsList", atmService.Get());
        model.addAttribute("transaction", transactionsService.Get());
        return "transaction/form";
    }


    @PostMapping("save")
    public String submit(Transaction transaction){
        Boolean result2= transactionsService.Save(transaction);
        if (result2) {
            return "redirect:/transaction";
        } else{
            return "transaction:/form";
        }
    }
}
