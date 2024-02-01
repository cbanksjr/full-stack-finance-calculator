package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.models.Vacation;

public interface VacationRepository extends CrudRepository<Vacation, Long>{
    
}
