package com.fullstackfinance.financecalculator.services;

import java.util.List;

import com.fullstackfinance.financecalculator.dtos.ExpensesDTO;

public interface ExpensesService {
    List<ExpensesDTO> expenseAllocation(long id, double percent);
}
