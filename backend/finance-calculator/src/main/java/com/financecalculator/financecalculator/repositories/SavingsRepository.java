package com.financecalculator.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.financecalculator.financecalculator.models.Savings;

public interface SavingsRepository extends CrudRepository<Savings, Long>{
    
}
