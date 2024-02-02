package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;

public interface AccountRepository extends CrudRepository<AccountDTO, Long> {
    
}
