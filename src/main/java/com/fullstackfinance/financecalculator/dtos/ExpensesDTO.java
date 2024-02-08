package com.fullstackfinance.financecalculator.dtos;

import lombok.*;


@Data
public class ExpensesDTO {
    private double amount;
    private double deducted;
    private double remaining;

}
