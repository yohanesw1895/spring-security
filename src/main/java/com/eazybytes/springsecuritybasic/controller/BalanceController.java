package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.AccountTransactions;
import com.eazybytes.springsecuritybasic.repository.AccountTransactionRepository;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    private final AccountTransactionRepository accountTransactionRepository;
    private final CustomerRepository customerRepository;

    public BalanceController(AccountTransactionRepository accountTransactionRepository,
                             CustomerRepository customerRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping(
            value = "/myBalance",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<AccountTransactions>> getMyBalanceDetails(@RequestParam String email) throws Exception {

        System.out.println("Here are the balance details from the DB");
        return ResponseEntity.ok(
                customerRepository.findOneByEmail(email)
                        .map(c -> accountTransactionRepository.findAllByCustomerIdOrderByTransactionDtDesc(c.getId()))
                        .orElseThrow(() -> new Exception("data not found"))

        );
    }

}
