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

import com.example.demo.entities.Customers;
import com.example.demo.handler.Response;
import com.example.demo.services.CustomersService;

@RestController
@RequestMapping("api")
public class CustomersRestController {
    @Autowired
    private CustomersService customersService;

    @GetMapping("customer")
    public ResponseEntity<Object> get(){
        return Response.generateResponse(HttpStatus.OK, "All data retrieved", customersService.Get());
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) String id) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",  customersService.Get(id));
    }

    @GetMapping("customer/name/{name}")
    public ResponseEntity<Object> getByName(@PathVariable(required = true) String name) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",  customersService.GetByName(name));
    }

    @PostMapping("customer")
    public ResponseEntity<Object> post(@RequestBody Customers customer) {
        Boolean result = customersService.Save(customer);
        if(result) {
            return Response.generateResponse(HttpStatus.CREATED,"Data has been saved" );
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST,"Unable to save data");
    }

    // UPDATE
    // localhost:8088/api/customer
    @PutMapping("customer")
    public ResponseEntity<Object> put(@RequestBody Customers customer) {
        Boolean result = customersService.Save(customer);
        if(result) {
            return Response.generateResponse(HttpStatus.OK,"data has been Updated");
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST,"Unable to Update data");
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<Object> put(@PathVariable(required = true) String id) {
        Boolean result = customersService.Delete(id);
        if(result) {
            return Response.generateResponse(HttpStatus.OK,"Data has been Deleted");
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST, "Unable to Delete data" );
    }
}
