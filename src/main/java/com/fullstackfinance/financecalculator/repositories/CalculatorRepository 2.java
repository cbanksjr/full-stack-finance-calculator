package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.models.Calculator;

public interface CalculatorRepository extends CrudRepository<Calculator, Long> {
    
}
