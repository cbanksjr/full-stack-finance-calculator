package com.financecalculator.financecalculator.services.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

import com.financecalculator.financecalculator.dtos.AccountDTO;
import com.financecalculator.financecalculator.models.Account;
import com.financecalculator.financecalculator.repositories.AccountRepository;
import com.financecalculator.financecalculator.services.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    
    private AccountRepository accountRepository;
    private ModelMapper modelMapper;

    //GET AMOUNT FROM ALLOCATION CHOICE REPOSITORY TO SHOW AMOUNT IN REACT ACCOUNT COMPONENT 
    
    @Override
    public List<AccountDTO> amountToAllocateFrom(long id) {
       List<AccountDTO> accountList = new ArrayList<>();
        try {
            Optional<Account> calculations = accountRepository.findById(id);
            if(calculations.isPresent()){
               double amount = calculations.get().getAmount();

               Account account = new Account();
               account.setAmount(amount);

               accountRepository.save(account);
               AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
               accountList.add(accountDTO);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return accountList;
    }
    

    @Override
    public List<AccountDTO> iterateIds(){
        List<AccountDTO> accountDTOList = new ArrayList<>();
        try {
            Iterable<Account> accounts = accountRepository.findAll();

            for(Account account : accounts){
                AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
                accountDTOList.add(accountDTO);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return accountDTOList;
    }
    
}
