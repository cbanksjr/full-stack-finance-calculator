package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.dtos.VacationDTO;

public interface VacationRepository extends CrudRepository<VacationDTO, Long>{
    
}
