package com.fullstackfinance.financecalculator.models;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.*;

@Entity
@AllArgsConstructor
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
}
