package com.ivr.cafeback.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String simpleShow(){
        return "Hello this page";
    }
}
