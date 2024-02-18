package com.fullstackfinance.financecalculator.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public ArrayList<AccountDTO> amountToAllocateFrom(long id) {
       ArrayList<AccountDTO> accountList = new ArrayList<>();
        try {
            Optional<Calculator> calculations = calculatorRepository.findById(id);
            if(calculations.isPresent()){
               double amount = calculations.get().getAmount();
               double deducted = calculations.get().getDeducted();
               double remaining = calculations.get().getRemaining();

               Account account = new Account();
               account.setAmount(amount);
               account.setDeducted(deducted);
               account.setRemaining(remaining);
               accountRepository.save(account);
               AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
               accountList.add(accountDTO);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return accountList;
    }

    
}
