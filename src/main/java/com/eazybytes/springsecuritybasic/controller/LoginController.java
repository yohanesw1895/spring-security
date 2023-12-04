package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Customer;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class LoginController {

    private final CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<Customer> register(
            @RequestBody Customer customer
    ) {

//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setCreateDt(new Date(System.currentTimeMillis()));
        Customer result = customerRepository.save(customer);
        return ResponseEntity.ok(result);
    }

    @GetMapping(
            value = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<Customer> getUserDetailsAfterLogin(
            Authentication authentication
    ) throws Exception {

        return ResponseEntity.ok(
                customerRepository.findOneByEmail(authentication.getName())
                    .orElseThrow(() -> new Exception("Data tidak ditemukan"))
        );
    }
}
