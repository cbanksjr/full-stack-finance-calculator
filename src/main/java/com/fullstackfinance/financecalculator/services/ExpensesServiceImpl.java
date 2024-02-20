package com.fullstackfinance.financecalculator.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fullstackfinance.financecalculator.dtos.ExpensesDTO;
import com.fullstackfinance.financecalculator.models.Account;
import com.fullstackfinance.financecalculator.models.Expenses;
import com.fullstackfinance.financecalculator.repositories.AccountRepository;
import com.fullstackfinance.financecalculator.repositories.ExpensesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpensesServiceImpl implements ExpensesService{

    private AccountRepository accountRepository;
    private ExpensesRepository expensesRepository;
    private ModelMapper modelMapper;

    @Override 
    public List<ExpensesDTO> expenseAllocation(long id, double percent) {
        List<ExpensesDTO> expensesList = new ArrayList<>();
        Expenses expenses = new Expenses();
        Account account = new Account();
        try {
            Optional<Account> accountInfo = accountRepository.findById(id);
            if(accountInfo.isPresent()){
                double accountAmount = accountInfo.get().getAmount();
                double allocateToExpense = accountAmount * (percent / 100);
                double remaining = (accountAmount - allocateToExpense);

                expenses.setAmount(accountAmount);
                expenses.setDeducted(allocateToExpense);
                expenses.setPercent(percent);
                expenses.setRemaining(remaining);
                expensesRepository.save(expenses);
                ExpensesDTO expensesDTO =  modelMapper.map(expenses, ExpensesDTO.class);
                expensesList.add(expensesDTO);

            
                account.setAmount(remaining);
                accountRepository.save(account);
            
                
            }  
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return expensesList;
    }
    



}
