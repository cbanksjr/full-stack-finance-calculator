package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.models.Savings;

public interface SavingsRepository extends CrudRepository<Savings, Long>{
    
}
