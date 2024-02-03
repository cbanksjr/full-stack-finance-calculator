package com.fullstackfinance.financecalculator.repositories;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.models.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    void save(double moneyToBeDeductedFrom);
    void save(LocalDate currentDate);
}
