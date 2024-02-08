package com.fullstackfinance.financecalculator.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fullstackfinance.financecalculator.dtos.ExpensesDTO;
import com.fullstackfinance.financecalculator.models.Calculator;
import com.fullstackfinance.financecalculator.models.Expenses;
import com.fullstackfinance.financecalculator.repositories.CalculatorRepository;
import com.fullstackfinance.financecalculator.repositories.ExpensesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpensesServiceImpl implements ExpensesService{

    private CalculatorRepository calculatorRepository;
    private ExpensesRepository expensesRepository;
    private ModelMapper modelMapper;

    @Override
    public ExpensesDTO financeAllocation(long id) {
        Expenses expenses = new Expenses();
        try {
            Optional<Calculator> accountInfo = calculatorRepository.findById(id);
            if(accountInfo.isPresent()){
                double sendToFinance = accountInfo.get().getDeducted();
                expenses.setAmount(sendToFinance);
                expensesRepository.save(expenses);
                return modelMapper.map(expenses, ExpensesDTO.class);
            }    
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return modelMapper.map(expenses, ExpensesDTO.class);
        }
        return null;
        
    }
    
}
