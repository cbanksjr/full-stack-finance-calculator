package com.fullstackfinance.financecalculator.services;

import com.fullstackfinance.financecalculator.dtos.CalculatorDTO;

public interface CalculatorService {
    CalculatorDTO calculate(double amount, double percent);
}
