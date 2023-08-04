package com.example.demo.controllers;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Accounts;
// import com.example.demo.entities.Banks;
import com.example.demo.services.AccountsService;
import com.example.demo.services.BanksService;

@Controller
@RequestMapping("account")
public class AccountsController {
    @Autowired
    private AccountsService accService;
    @Autowired
    private BanksService banksService;
    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("accounts", accService.Get());
        return "account/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(@PathVariable(required = false) String id, Model model) {
        // List<Banks> bankList = banksService.Get();
        if (id != null) {
            model.addAttribute("account", accService.Get(id));
            model.addAttribute("banksList", banksService.Get());
        } else {
            model.addAttribute("banksList", banksService.Get());
            model.addAttribute("account", new Accounts());
        }
        return "account/form";
    }

    // @GetMapping("form")
    // public String form(Model model){
    //     model.addAttribute("accounts", new Accounts());
    //     return "accounts/form";
    // }

    @PostMapping("save")
    public String submit(Accounts account){
        Boolean result= accService.Save(account);
        if (result) {
            return "redirect:/account";
        } else{
            return "account:/form";
        }
    }
    // save
    // accounts/save
    // @PostMapping("save")
    // public String accountsSave(Accounts accounts) {
    //     accountsService.Save(accounts);
    //     return "redirect:/accounts";
    // }

    // delete
    // accounts/delete/1
    @PostMapping("delete/{id}")
    public String accountDelete(@PathVariable(required =true) String id){
        accService.Delete(id);
        return "redirect:/account";
    }
}
