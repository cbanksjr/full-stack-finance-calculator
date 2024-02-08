package com.fullstackfinance.financecalculator.dtos;

import lombok.Data;

@Data
public class CalculatorDTO {
    private double amount;
    private double deducted;
    private double percent;
}
