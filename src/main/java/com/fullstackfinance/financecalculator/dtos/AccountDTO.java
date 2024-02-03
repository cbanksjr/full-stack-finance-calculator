package com.fullstackfinance.financecalculator.dtos;

import lombok.*;
import java.time.LocalDate;


@Data
public class AccountDTO {
    private LocalDate date;
    private double amount;
    private double deducted;
    private double remaining;
}
