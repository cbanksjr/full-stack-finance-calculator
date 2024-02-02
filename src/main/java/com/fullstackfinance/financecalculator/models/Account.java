package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Account extends Allocation{
    
    public Account(double amount, double total, double deducted, double remaining){
        super(amount, total, deducted, remaining);
    }

    
}
