package com.fullstackfinance.financecalculator.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;
import com.fullstackfinance.financecalculator.models.Account;
import com.fullstackfinance.financecalculator.models.Calculator;
import com.fullstackfinance.financecalculator.repositories.AccountRepository;
import com.fullstackfinance.financecalculator.repositories.CalculatorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    private CalculatorRepository calculatorRepository;
    private ModelMapper modelMapper;


    @Override
    public AccountDTO amountToAllocateFrom(long id) {
        Account account = new Account();
        try {
            Optional<Calculator> calculations = calculatorRepository.findById(id);
            if(calculations.isPresent()){
               double amount = calculations.get().getAmount();
               account.setAmount(amount);
               accountRepository.save(account);
               return modelMapper.map(account, AccountDTO.class);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return modelMapper.map(account, AccountDTO.class);
        }
        return null;
    }

    
}
