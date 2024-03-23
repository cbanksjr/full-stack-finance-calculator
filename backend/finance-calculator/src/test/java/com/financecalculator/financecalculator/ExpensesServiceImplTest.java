package com.financecalculator.financecalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.financecalculator.financecalculator.dtos.ExpensesDTO;
import com.financecalculator.financecalculator.services.ServiceImpl.ExpensesServiceImpl;

@SpringBootTest
class ExpensesServiceImplTest {
    
    @Autowired
    private ExpensesServiceImpl expensesService;
    

    @Test
    public void testMoneyInExpenses() {
        // Arrange
        double amount = 1000.0;
        double percent = 10.0;

        // Act
        List<ExpensesDTO> result = expensesService.moneyInExpenses(amount, percent);

        // Assert
        assertFalse(result.isEmpty(), "Result should not be empty");
        
    }

    @Test
    public void testGetAllExpenses() {
        // Arrange
        testMoneyInExpenses();

        // Act
        List<ExpensesDTO> result = expensesService.getAllExpenses();

        // Assert
        assertFalse(result.isEmpty(), "Result should not be empty");
        assertEquals(1, result.size(), "Result should contain only one expenses");
    }

    @Test
    public void testMoneyOutOfExpenses() {
        // Arrange
        testMoneyInExpenses();
        double amount = 1000.0;

        // Act
        List<ExpensesDTO> result = expensesService.moneyOutOfExpenses(amount);

        // Check if allocationTakenOutAmount is greater than 0 and if total allocation minus allocation taken out is equal to total allocation taken out
        if(!result.isEmpty()){
            assertTrue(result.get(0).getTotalAllocation() > 0, "Allocation taken out amount should be greater than 0");
            assertTrue(result.get(0).getTotalAllocation() - result.get(0).getAllocationTakenOut() == result.get(0).getTotalAllocationTakenOut(), "Total allocation minus allocation taken out should be equal to remaining");
        }
    }
}

