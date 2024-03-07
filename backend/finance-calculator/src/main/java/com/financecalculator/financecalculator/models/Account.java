package com.financecalculator.financecalculator.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue
    private long id;
    private double amount;
    private double deducted;
    private double remaining;
    // private double percent;

    public Account(double amount, double deducted, double remaining) {
        this.amount = amount;
        this.deducted = deducted;
        this.remaining = remaining;
        // this.percent = percent;
    }
}
