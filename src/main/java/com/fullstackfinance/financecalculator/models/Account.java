package com.fullstackfinance.financecalculator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate date;
    private double amount;
    private double deducted;
    private double remaining;
    
}
