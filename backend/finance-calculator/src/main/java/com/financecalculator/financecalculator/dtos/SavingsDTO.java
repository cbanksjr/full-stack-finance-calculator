package com.financecalculator.financecalculator.dtos;

import lombok.Data;

@Data
public class SavingsDTO{
    double initialAmount; 
    double allocatedAmount; 
    double percent; 
    double amountRemaining;
}
