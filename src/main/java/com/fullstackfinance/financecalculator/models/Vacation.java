package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Vacation extends Allocation {
    
    public Vacation(double amount, double total, double deducted){
        super(amount, total, deducted);
    }
}
