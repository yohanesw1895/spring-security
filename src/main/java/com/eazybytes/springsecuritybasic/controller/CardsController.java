package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Cards;
import com.eazybytes.springsecuritybasic.repository.CardsRepository;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final CardsRepository cardsRepository;
    private final CustomerRepository customerRepository;

    public CardsController(CardsRepository cardsRepository, CustomerRepository customerRepository) {
        this.cardsRepository = cardsRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping(
            value = "/myCards",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Cards>> getMyCardDetails(@RequestParam String email) throws Exception {

        System.out.println("Here are the card details from the DB");
        return ResponseEntity.ok(
                customerRepository.findOneByEmail(email)
                                .map(c -> cardsRepository.findAllByCustomerId(c.getId()))
                        .orElseThrow(() -> new Exception("Data tidak ditemukan"))

        );
    }

}
