package com.fullstackfinance.financecalculator.services;

import com.fullstackfinance.financecalculator.dtos.ExpensesDTO;

public interface ExpensesService {
    ExpensesDTO financeAllocation(long id);
}
