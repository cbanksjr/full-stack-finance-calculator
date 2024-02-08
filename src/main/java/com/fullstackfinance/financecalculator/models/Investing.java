package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Investing extends Allocation {

    public Investing(double amount, double deducted, double remaining){
        super(amount, deducted, remaining);
    }
}
