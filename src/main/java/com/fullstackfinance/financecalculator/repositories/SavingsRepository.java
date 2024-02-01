package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.dtos.SavingsDTO;

public interface SavingsRepository extends CrudRepository<SavingsDTO, Long>{
    
}
