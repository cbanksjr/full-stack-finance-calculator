package com.financecalculator.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.financecalculator.financecalculator.models.Expenses;

public interface ExpensesRepository extends CrudRepository<Expenses, Long>{
    
}
