package com.financecalculator.financecalculator.services;

import java.util.List;

import com.financecalculator.financecalculator.dtos.SavingsDTO;

public interface SavingsService {
    List<SavingsDTO> moneyInSavings(double amount, double percent);

    SavingsDTO moneyOutOfSavings(double amount, long allocationId);
}
