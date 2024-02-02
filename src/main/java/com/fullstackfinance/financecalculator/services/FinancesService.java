package com.fullstackfinance.financecalculator.services;

import com.fullstackfinance.financecalculator.dtos.FinancesDTO;

public interface FinancesService {
    FinancesDTO addedAmount();
    FinancesDTO total();
    FinancesDTO deductedAmount();
    FinancesDTO remainingAmount();
}
