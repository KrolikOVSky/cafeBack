package com.ivr.cafeback.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String simpleShow() {
        return "Hello this page updated\n";
    }
}
