package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Finances extends Allocation {
    
    public Finances(double amount, double total, double deducted){
        super(amount, total, deducted);
    }
}
