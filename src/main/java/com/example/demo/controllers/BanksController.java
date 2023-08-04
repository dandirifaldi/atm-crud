package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Banks;
import com.example.demo.services.BanksService;

@Controller
@RequestMapping("bank")
public class BanksController {
    @Autowired
    private BanksService bankService;
    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("banks", bankService.Get());
        return "bank/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(@PathVariable(required = false) String id, Model model) {
        if (id != null) {
            model.addAttribute("bank", bankService.Get(id));
        } else {
            model.addAttribute("bank", new Banks());
        }
        return "banks/form";
    }

    // @GetMapping("form")
    // public String form(Model model){
    //     model.addAttribute("banks", new Banks());
    //     return "banks/form";
    // }

    @PostMapping("save")
    public String submit(Banks bank){
        Boolean result= bankService.Save(bank);
        if (result) {
            return "redirect:/bank";
        } else{
            return "banks:/form";
        }
    }
    // save
    // banks/save
    // @PostMapping("save")
    // public String banksSave(Banks banks) {
    //     banksService.Save(banks);
    //     return "redirect:/banks";
    // }

    // delete
    // banks/delete/1
    @PostMapping("delete/{id}")
    public String bankDelete(@PathVariable(required =true) String id){
        bankService.Delete(id);
        return "redirect:/bank";
    }
}
