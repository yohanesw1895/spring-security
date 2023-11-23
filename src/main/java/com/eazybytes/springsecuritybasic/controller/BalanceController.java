package com.eazybytes.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/myBalance")
    public String getMyBalanceDetails() {

        System.out.println("Here are the balance details from the DB");
        return "Here are the balance details from the DB";
    }

}
