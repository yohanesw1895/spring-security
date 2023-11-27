package com.eazybytes.springsecuritybasic.repository;

import com.eazybytes.springsecuritybasic.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {

    List<Cards> findAllByCustomerId(int customerId);
}
