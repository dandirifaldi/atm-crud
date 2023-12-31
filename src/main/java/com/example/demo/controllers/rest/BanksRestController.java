package com.example.demo.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Banks;
import com.example.demo.handler.Response;
import com.example.demo.services.BanksService;

@RestController
@RequestMapping("api")
public class BanksRestController {
    @Autowired
    private BanksService banksService;

    @GetMapping("bank")
    public ResponseEntity<Object> get(){
        return Response.generateResponse(HttpStatus.OK, "All data retrieved", banksService.Get());
    }

    @GetMapping("bank/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) String id) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",  banksService.Get(id));
    }

    @PostMapping("bank")
    public ResponseEntity<Object> post(@RequestBody Banks bank) {
        Boolean result = banksService.Save(bank);
        if(result) {
            return Response.generateResponse(HttpStatus.CREATED,"Data has been saved" );
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST,"Unable to save data");
    }

    // UPDATE
    // localhost:8088/api/bank
    @PutMapping("bank")
    public ResponseEntity<Object> put(@RequestBody Banks bank) {
        Boolean result = banksService.Save(bank);
        if(result) {
            return Response.generateResponse(HttpStatus.OK,"data has been Updated");
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST,"Unable to Update data");
    }

    @DeleteMapping("bank/{id}")
    public ResponseEntity<Object> put(@PathVariable(required = true) String id) {
        Boolean result = banksService.Delete(id);
        if(result) {
            return Response.generateResponse(HttpStatus.OK,"Data has been Deleted");
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST, "Unable to Delete data" );
    }
}
