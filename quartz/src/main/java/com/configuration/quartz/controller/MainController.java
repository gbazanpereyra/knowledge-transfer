package com.configuration.quartz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api-https")
public class MainController {

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        Map<String, Object> response = new HashMap<>();
        response.put("messagge", "Hola mundo!");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
