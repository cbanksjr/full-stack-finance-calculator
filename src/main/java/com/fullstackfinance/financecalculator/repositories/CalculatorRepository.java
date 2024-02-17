package com.fullstackfinance.financecalculator.repositories;


import com.fullstackfinance.financecalculator.models.Calculator;
import org.springframework.data.repository.CrudRepository;

public interface CalculatorRepository extends CrudRepository<Calculator, Long> {
}
