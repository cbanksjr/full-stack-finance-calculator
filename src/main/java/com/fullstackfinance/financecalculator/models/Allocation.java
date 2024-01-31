package com.fullstackfinance.financecalculator.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allocation {
    private double amount;
    private double total;
    private double deducted;
}
