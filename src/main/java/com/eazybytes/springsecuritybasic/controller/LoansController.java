package com.eazybytes.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/myLoans")
    public String getMyLoanDetails() {

        System.out.println("Here are the loan details from the DB");
        return "Here are the loan details from the DB";
    }

}
