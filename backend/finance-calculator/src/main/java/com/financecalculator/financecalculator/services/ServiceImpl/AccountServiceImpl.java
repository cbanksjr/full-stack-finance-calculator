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


    /*
     * Subtracts remainining amounts from account repository
     */
    @Override
    public List<AccountDTO> retrieveAmounts(){
        List<AccountDTO> accountDTOList = new ArrayList<>();
        try {
            Iterable<Account> accounts = accountRepository.findAll();

            //Converts Account to AccountDTO
            accounts.forEach(account -> {
                AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
                accountDTOList.add(accountDTO);
            });

            //Taking finding remaining amount and setting remaining
            accountDTOList.forEach(accountDTO -> {
                double previousValue = 0.0;
                double remaining = accountDTO.getRemaining();
                double difference = remaining - previousValue;
                accountDTO.setRemaining(difference);
                previousValue = remaining;
            });

            //Return the last accountDTO in the list
            AccountDTO accountDTO = accountDTOList.size() >= 1 ? accountDTOList.get(accountDTOList.size() - 1) : accountDTOList.get(0);
            List<AccountDTO> result = new ArrayList<>();
            result.add(accountDTO);
            return result;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return accountDTOList;
    }
    
}
