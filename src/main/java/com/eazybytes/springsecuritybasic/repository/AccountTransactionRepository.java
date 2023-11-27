package com.eazybytes.springsecuritybasic.repository;

import com.eazybytes.springsecuritybasic.model.AccountTransactions;
import com.eazybytes.springsecuritybasic.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountTransactionRepository extends CrudRepository<AccountTransactions, Long> {

    List<AccountTransactions> findAllByCustomerIdOrderByTransactionDtDesc(int customerId);
}
