package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Loans;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import com.eazybytes.springsecuritybasic.repository.LoanRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;

    public LoansController(LoanRepository loanRepository, CustomerRepository customerRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping(
            value = "/myLoans",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Loans>> getMyLoanDetails(@RequestParam String email) throws Exception {

        System.out.println("Here are the loan details from the DB");
        return ResponseEntity.ok(
                customerRepository.findOneByEmail(email)
                                .map(c -> loanRepository.findAllByCustomerIdOrderByStartDtDesc(c.getId()))
                        .orElseThrow(() -> new Exception("Data tidak ditemukan"))

        );
    }

}
