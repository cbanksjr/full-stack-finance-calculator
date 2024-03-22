package com.financecalculator.financecalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.financecalculator.financecalculator.dtos.AccountDTO;
import com.financecalculator.financecalculator.repositories.SavingsRepository;
import com.financecalculator.financecalculator.services.ServiceImpl.AccountServiceImpl;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private SavingsRepository savingsRepository;   
    

    @Test
    public void testRetrieveAmounts() {
        // Act
        List<AccountDTO> result = accountService.retrieveAmounts();

        // Assert
        if(!result.isEmpty()){
            assertTrue(result.get(result.size() - 1).getAmount() == savingsRepository.findAll().iterator().next().getInitialAmount(), "Result should contain the inital amount from the savings repository");
            assertTrue(result.get(result.size() - 1).getRemaining() == savingsRepository.findAll().iterator().next().getAllocatedAmount(), "Result should contain the allocated amount from the savings repository");
        }
    }
}
