package com.fullstackfinance.financecalculator.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fullstackfinance.financecalculator.dtos.CalculatorDTO;
import com.fullstackfinance.financecalculator.models.Calculator;
import com.fullstackfinance.financecalculator.repositories.CalculatorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CalculatorServiceImpl implements CalculatorService {
    private CalculatorRepository calculatorRepository;
    private ModelMapper modelMapper;

    @Override
    public CalculatorDTO addToAccount(double amount) {
        Calculator calculator = new Calculator();

        try {
            if (amount <= 0) {
                throw new IllegalArgumentException();
            }
            calculator.setAmount(amount);
            calculatorRepository.save(calculator);
            return modelMapper.map(calculator, CalculatorDTO.class);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return modelMapper.map(calculator, CalculatorDTO.class);
        }
    }
}
