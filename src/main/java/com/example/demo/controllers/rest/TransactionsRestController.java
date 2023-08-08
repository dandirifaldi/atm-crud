package com.example.demo.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Transactions;
import com.example.demo.handler.Response;
import com.example.demo.services.TransactionsService;

@RestController
@RequestMapping("api")
public class TransactionsRestController {
    @Autowired
    private TransactionsService transactionsService;
    
    @GetMapping("transaction")
    public ResponseEntity<Object> get(){
        return Response.generateResponse(HttpStatus.OK, "All data retrieved", transactionsService.Get());
    }

    @GetMapping("transaction/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",  transactionsService.Get(id));
    }

    @PostMapping("transaction")
    public ResponseEntity<Object> post(@RequestBody Transactions transaction) {
        Boolean result = transactionsService.Save(transaction);
        if(result) {
            return Response.generateResponse(HttpStatus.CREATED,"Data has been saved" );
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST,"Unable to save data");
    }

}
