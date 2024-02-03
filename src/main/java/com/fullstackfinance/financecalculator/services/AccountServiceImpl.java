package com.fullstackfinance.financecalculator.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;
import com.fullstackfinance.financecalculator.models.Account;
import com.fullstackfinance.financecalculator.repositories.AccountRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;
    private ModelMapper modelMapper;


    @Override
    public AccountDTO setAmountToDeductFrom(String moneyToBeDeductedFrom) {
        Account account = new Account();
        LocalDate currentDate = LocalDate.now();
        try {
            if (Double.parseDouble(moneyToBeDeductedFrom) <= 0) {
                throw new IllegalArgumentException();
            }
            account.setDate(currentDate);
            account.setAmount(Double.parseDouble(moneyToBeDeductedFrom));
            accountRepository.save(account);
            return modelMapper.map(account, AccountDTO.class);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            account.setAmount(0);
            return modelMapper.map(account, AccountDTO.class);
        }
    }

    @Override
    public AccountDTO getAmountAfterDeductions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AccountDTO setAmountRemaining() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
