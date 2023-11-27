package com.eazybytes.springsecuritybasic.repository;

import com.eazybytes.springsecuritybasic.model.Accounts;
import com.eazybytes.springsecuritybasic.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Long> {

    Optional<Accounts> findOneByCustomerId(int customerId);
}
