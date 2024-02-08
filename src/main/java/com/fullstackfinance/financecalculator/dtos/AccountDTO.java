package com.fullstackfinance.financecalculator.dtos;

import lombok.*;


@Data
public class AccountDTO {
    private double amount;
    private double deducted;
    private double remaining;
    private double percent;
}
