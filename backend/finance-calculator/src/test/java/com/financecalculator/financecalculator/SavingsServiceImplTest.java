package com.financecalculator.financecalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.financecalculator.financecalculator.dtos.SavingsDTO;
import com.financecalculator.financecalculator.services.ServiceImpl.SavingsServiceImpl;

@SpringBootTest
class SavingsServiceImplTest {

	@Autowired
    private SavingsServiceImpl savingsService;
    

	@Test
	public void testMoneyInSavings() {
        // Arrange
        double amount = 1000.0;
        double percent = 10.0;

        // Act
        List<SavingsDTO> result = savingsService.moneyInSavings(amount, percent);

        // Assert
        assertFalse(result.isEmpty(), "Result should not be empty");
    }

	@Test
    public void testGetAllSavings() {

        testMoneyInSavings();

        // Act
        List<SavingsDTO> result = savingsService.getAllSavings();

        // Assert
        assertFalse(result.isEmpty(), "Result should not be empty");
        assertEquals(1, result.size(), "Result should contain only one savings");
    }

    @Test
    public void testMoneyOutOfSavings() {

        testMoneyInSavings();

        // Arrange
        double amount = 1000.0;

        // Act
        List<SavingsDTO> result = savingsService.moneyOutOfSavings(amount);

        // Check if allocationTakenOutAmount is greater than 0 and if total allocation minus allocation taken out is equal to total allocation taken out
        if(!result.isEmpty()){
            assertTrue(result.get(0).getTotalAllocation() > 0, "Allocation taken out amount should be greater than 0");
            assertTrue(result.get(0).getTotalAllocation() - result.get(0).getAllocationTakenOut() == result.get(0).getTotalAllocationTakenOut(), "Total allocation minus allocation taken out should be equal to remaining");
        }

    }
    

}
