package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Savings extends Allocation {
        
    public Savings(double amount, double total, double deducted){
            super(amount, total, deducted);
        }

    
}
