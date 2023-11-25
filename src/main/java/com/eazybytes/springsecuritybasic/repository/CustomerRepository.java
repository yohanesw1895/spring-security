package com.eazybytes.springsecuritybasic.repository;

import com.eazybytes.springsecuritybasic.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findOneByEmail(String email);
}
