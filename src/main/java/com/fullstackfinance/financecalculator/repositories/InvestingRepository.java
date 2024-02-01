package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.dtos.InvestingDTO;

public interface InvestingRepository extends CrudRepository<InvestingDTO, Long>{
    
}
