package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Customer;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final CustomerRepository customerRepository;

    public AccountController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(
            value = "/myAccount",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> getMyAccount(@RequestParam String email) throws Exception {

        System.out.println("Here are the account details from the DB");
        return ResponseEntity.ok(
                customerRepository.findOneByEmail(email)
                        .orElseThrow(() -> new Exception("data not found"))
        );
    }

}
