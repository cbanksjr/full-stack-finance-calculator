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
    @Override
    public CalculatorDTO multiplyAccountFromPercent(double amount, double percent) {
        Calculator calculator = new Calculator();
        try {
          double getAmount = calculatorRepository.findByAmount(amount);
          calculator.setPercent(percent);
          double amountToDeduct = getAmount * percent;
          calculator.setDeducted(amountToDeduct);
          double remaining = getAmount - amountToDeduct;
          calculator.setRemaining(remaining);
          calculatorRepository.save(calculator);
          return modelMapper.map(calculator, CalculatorDTO.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return modelMapper.map(calculator, CalculatorDTO.class);
        }
    }
}
