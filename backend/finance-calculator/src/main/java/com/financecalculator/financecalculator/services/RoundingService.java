package com.financecalculator.financecalculator.services;
import java.math.BigDecimal;

public interface RoundingService {
    BigDecimal round(double value, int places);
}
