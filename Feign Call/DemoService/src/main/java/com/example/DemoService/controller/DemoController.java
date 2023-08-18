package com.example.DemoService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
    @GetMapping("/name")
    public String getName(){
        return "Riya";
    }
    @GetMapping("/address")
    public String getAddress(){
        return "India";
    }
    @GetMapping("/status")
    public String getStatus(){
        return "active";
    }

}
