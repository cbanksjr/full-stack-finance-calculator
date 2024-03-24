package com.financecalculator.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.financecalculator.financecalculator.models.Vacation;

public interface VacationRepository extends CrudRepository<Vacation, Long> {
    
}
