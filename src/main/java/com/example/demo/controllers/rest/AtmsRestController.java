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

import com.example.demo.entities.Atms;
import com.example.demo.handler.Response;
import com.example.demo.services.AtmsService;

@RestController
@RequestMapping("api")
public class AtmsRestController {
    @Autowired
    private AtmsService atmsService;

    @GetMapping("atm")
    public ResponseEntity<Object> get(){
        return Response.generateResponse(HttpStatus.OK, "All data retrieved", atmsService.Get());
    }

    @GetMapping("atm/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",  atmsService.Get(id));
    }

    @PostMapping("atm")
    public ResponseEntity<Object> post(@RequestBody Atms atm) {
        Boolean result = atmsService.Save(atm);
        if(result) {
            return Response.generateResponse(HttpStatus.CREATED,"Data has been saved" );
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST,"Unable to save data");
    }

    // UPDATE
    // localhost:8088/api/atm
    @PutMapping("atm")
    public ResponseEntity<Object> put(@RequestBody Atms atm) {
        Boolean result = atmsService.Save(atm);
        if(result) {
            return Response.generateResponse(HttpStatus.OK,"Data has been Updated");
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST,"Unable to Update data");
    }

    @DeleteMapping("atm/{id}")
    public ResponseEntity<Object> put(@PathVariable(required = true) Integer id) {
        Boolean result = atmsService.Delete(id);
        if(result) {
            return Response.generateResponse(HttpStatus.OK,"Data has been Deleted");
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST, "Unable to Delete data" );
    }
}
