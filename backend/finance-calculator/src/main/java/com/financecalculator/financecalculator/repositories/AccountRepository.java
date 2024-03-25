package com.financecalculator.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.financecalculator.financecalculator.models.Account;


public interface AccountRepository extends CrudRepository<Account, Long> {

}
