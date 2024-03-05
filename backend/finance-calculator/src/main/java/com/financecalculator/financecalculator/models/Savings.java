package com.financecalculator.financecalculator.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Savings{
    @Id
    @GeneratedValue
    private long id;

    private double initialAmount;
    private double allocatedAmount;
    private double percent;
    private double amountRemaining;

    public Savings(double initialAmount, double allocatedAmount, double percent, double amountRemaining){
        this.initialAmount = initialAmount;
        this.allocatedAmount = allocatedAmount;
        this.percent = percent;
        this.amountRemaining = amountRemaining;
    }
}
