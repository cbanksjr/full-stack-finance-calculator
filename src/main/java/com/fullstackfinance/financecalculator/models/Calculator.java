package com.fullstackfinance.financecalculator.models;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
public class Calculator {
    @Id
    @GeneratedValue
    private long id;
    private double amount;
    private double deducted;
    private double percent;
    private double remaining;


    public Calculator(double amount, double deducted, double percent, double remaining) {
        this.amount = amount;
        this.deducted = deducted;
        this.percent = percent;
        this.remaining = remaining;
    }
}
