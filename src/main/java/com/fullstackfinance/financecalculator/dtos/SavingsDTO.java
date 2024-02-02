package com.fullstackfinance.financecalculator.dtos;

import lombok.*;

@Data
public class SavingsDTO {
    private double amount;
    private double total;
    private double deducted;
    private double remaining;
}
