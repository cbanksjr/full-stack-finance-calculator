package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Savings extends Allocation {
        
    public Savings(double amount, double deducted, double remaining, double percent){
        super(amount, deducted, remaining, percent);
    }

    
}
