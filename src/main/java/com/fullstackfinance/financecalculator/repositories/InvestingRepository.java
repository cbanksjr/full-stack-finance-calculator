package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.models.Investing;

public interface InvestingRepository extends CrudRepository<Investing, Long>{
    
}
