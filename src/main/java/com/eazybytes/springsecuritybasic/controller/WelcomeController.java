package com.eazybytes.springsecuritybasic.controller;

import org.apache.catalina.security.SecurityUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String sayWelcome() {

        System.out.println("Welcome to Spring Application with Security ");
        return "Welcome to Spring Application with Security";
    }

}
