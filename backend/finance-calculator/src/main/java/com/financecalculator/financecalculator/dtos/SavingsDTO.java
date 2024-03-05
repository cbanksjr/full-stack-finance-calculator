package com.financecalculator.financecalculator.dtos;

import lombok.Data;

@Data
public class SavingsDTO{
    double initialAmount; 
    double allocatedAmount; 
    double totalAllocation;
    double percent; 
    double amountRemaining;
}
