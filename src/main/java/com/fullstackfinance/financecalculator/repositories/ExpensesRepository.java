package com.fullstackfinance.financecalculator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstackfinance.financecalculator.models.Expenses;

public interface ExpensesRepository extends CrudRepository<Expenses, Long> {


}
