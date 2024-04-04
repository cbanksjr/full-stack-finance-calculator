package com.financecalculator.financecalculator.services;

import java.util.List;

import com.financecalculator.financecalculator.dtos.VacationDTO;

public interface VacationService {
    List<VacationDTO> moneyForVacation(double amount, double percent);

    List<VacationDTO> getAllVacation();

    List<VacationDTO> moneyOutOfVacation(double amount);
}
