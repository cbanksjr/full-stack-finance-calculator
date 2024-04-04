package com.financecalculator.financecalculator.services;

import java.util.List;

import com.financecalculator.financecalculator.dtos.ExpensesDTO;

public interface ExpensesService {
    List<ExpensesDTO> moneyInExpenses(double amount, double percent);

    List<ExpensesDTO> getAllExpenses();

    List<ExpensesDTO> moneyOutOfExpenses(double amount);
}
