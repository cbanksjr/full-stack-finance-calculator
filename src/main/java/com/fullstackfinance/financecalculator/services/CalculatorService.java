package com.fullstackfinance.financecalculator.services;

import com.fullstackfinance.financecalculator.dtos.CalculatorDTO;

public interface CalculatorService {
    CalculatorDTO addToAccount(double amount);

    CalculatorDTO multiplyAccountFromPercent(double amount, double percent);
}
