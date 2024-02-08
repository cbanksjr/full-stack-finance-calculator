package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue
    private long id;
    private double amount;
    private double deducted;
    private double remaining;
    private double percent;
    
}
