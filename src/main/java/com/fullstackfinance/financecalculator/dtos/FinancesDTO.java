package com.fullstackfinance.financecalculator.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class FinancesDTO {
    protected double amount;
    protected double total;
    protected double deducted;
    protected double remaining;

}
