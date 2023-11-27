package com.eazybytes.springsecuritybasic.repository;

import com.eazybytes.springsecuritybasic.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

    List<Loans> findAllByCustomerIdOrderByStartDtDesc(int customerId);

}
