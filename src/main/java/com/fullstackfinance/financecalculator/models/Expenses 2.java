package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Expenses extends Allocation {

    public Expenses(double amount, double deducted, double remaining) {
        super(amount, deducted, remaining);
    }
}
