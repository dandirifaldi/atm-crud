package com.example.demo.controllers;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Atms;
// import com.example.demo.entities.Banks;
import com.example.demo.services.AtmsService;
import com.example.demo.services.BanksService;

@Controller
@RequestMapping("atm")
public class AtmsController {
    @Autowired
    private AtmsService atmService;
    @Autowired
    private BanksService banksService;
    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("atms", atmService.Get());
        return "atm/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(@PathVariable(required = false) Integer id, Model model) {
        // List<Banks> bankList = banksService.Get();
        if (id != null) {
            model.addAttribute("atm", atmService.Get(id));
            model.addAttribute("banksList", banksService.Get());
        } else {
            model.addAttribute("banksList", banksService.Get());
            model.addAttribute("atm", new Atms());
        }
        return "atm/form";
    }

    // @GetMapping("form")
    // public String form(Model model){
    //     model.addAttribute("atms", new Atms());
    //     return "atms/form";
    // }

    @PostMapping("save")
    public String submit(Atms atm){
        Boolean result= atmService.Save(atm);
        if (result) {
            return "redirect:/atm";
        } else{
            return "atm:/form";
        }
    }
    // save
    // atms/save
    // @PostMapping("save")
    // public String atmsSave(Atms atms) {
    //     atmsService.Save(atms);
    //     return "redirect:/atms";
    // }

    // delete
    // atms/delete/1
    @PostMapping("delete/{id}")
    public String atmDelete(@PathVariable(required =true) Integer id){
        atmService.Delete(id);
        return "redirect:/atm";
    }
}
