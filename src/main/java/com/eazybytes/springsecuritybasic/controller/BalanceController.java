package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.AccountTransactions;
import com.eazybytes.springsecuritybasic.repository.AccountTransactionRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    private final AccountTransactionRepository accountTransactionRepository;

    public BalanceController(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @GetMapping(
            value = "/myBalance",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<AccountTransactions>> getMyBalanceDetails(@RequestParam int id) {

        System.out.println("Here are the balance details from the DB");
        return ResponseEntity.ok(
                accountTransactionRepository.findAllByCustomerIdOrderByTransactionDtDesc(id)
        );
    }

}
