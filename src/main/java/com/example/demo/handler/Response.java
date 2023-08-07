package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Response
 */
public class Response {
    public static ResponseEntity<Object> generateResponse( HttpStatus status, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status.value());
        map.put("message", message);

        return new ResponseEntity<Object>(map,status);
    }
    
    public static ResponseEntity<Object> generateResponse( HttpStatus status, String message, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", responseObj);
        map.put("status", status.value());
        map.put("message", message);

        return new ResponseEntity<Object>(map,status);
    }
}