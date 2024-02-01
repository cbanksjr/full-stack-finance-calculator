package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.models.Finances;


public interface FinancesRepository extends CrudRepository<Finances, Long>{
    
}
