package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Accounts;
import com.eazybytes.springsecuritybasic.repository.AccountRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(
            value = "/myAccount",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Accounts> getMyAccount(@RequestParam int id) throws Exception {

        System.out.println("Here are the account details from the DB");
        return ResponseEntity.ok(
                accountRepository.findOneByCustomerId(id)
                        .orElseThrow(() -> new Exception("data not found"))
        );
    }

}
