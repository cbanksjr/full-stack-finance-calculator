package com.fullstackfinance.financecalculator.repositories;


import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.models.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
