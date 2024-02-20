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
    private double amount;
    private double deducted;
    private double remaining;
    private double percent;

    

    public Allocation(double amount, double deducted, double remaining, double percent){
        this.amount = amount;
        this.deducted = deducted;
        this.remaining = remaining;
        this.percent = percent;
    }
}