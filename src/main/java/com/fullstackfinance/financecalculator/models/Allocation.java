package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Allocation {
    @Id
    @GeneratedValue
    private long id;
    
    protected double amount;
    protected double total;
    protected double deducted;
    protected double remaining;

    public Allocation(double amount, double total, double deducted, double remaining){
        this.amount = amount;
        this.total = total;
        this.deducted = deducted;
        this.remaining = remaining;
    }
}