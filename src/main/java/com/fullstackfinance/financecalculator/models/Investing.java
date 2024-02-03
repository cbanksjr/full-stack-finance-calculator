package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Investing extends Allocation {

    public Investing(double amount, double total, double deducted, double remaining, double percent){
        super(amount, total, deducted, remaining, percent);
    }
}
