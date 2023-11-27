package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Cards;
import com.eazybytes.springsecuritybasic.repository.CardsRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping(
            value = "/myCards",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Cards>> getMyCardDetails(@RequestParam int id) {

        System.out.println("Here are the card details from the DB");
        return ResponseEntity.ok(
                cardsRepository.findAllByCustomerId(id)
        );
    }

}
