package com.eazybytes.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getMyAccount() {

        System.out.println("Here are the account details from the DB");
        return "Here are the account details from the DB";
    }

}
