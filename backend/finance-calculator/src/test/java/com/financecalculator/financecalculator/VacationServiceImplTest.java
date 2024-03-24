package com.financecalculator.financecalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.financecalculator.financecalculator.dtos.VacationDTO;
import com.financecalculator.financecalculator.services.ServiceImpl.VacationServiceImpl;

@SpringBootTest
class VacationServiceImplTest {
    
    @Autowired
    private VacationServiceImpl vacationService;

    @Test
    public void testMoneyForVacation() {
        // Arrange
        double amount = 1000.0;
        double percent = 10.0;

        // Act
        List<VacationDTO> result = vacationService.moneyForVacation(amount, percent);

        // Assert
        assertFalse(result.isEmpty(), "Result should not be empty");
    }

    @Test
    public void testGetAllVacation() {

        testMoneyForVacation();

        // Act
        List<VacationDTO> result = vacationService.getAllVacation();

        // Assert
        assertFalse(result.isEmpty(), "Result should not be empty");
        assertEquals(1, result.size(), "Result should contain only one vacation");
    }

    @Test
    public void testMoneyOutOfVacation() {

        testMoneyForVacation();

        // Arrange
        double amount = 1000.0;

        // Act
        List<VacationDTO> result = vacationService.moneyOutOfVacation(amount);

        // Check if allocationTakenOutAmount is greater than 0 and if total allocation minus allocation taken out is equal to total allocation taken out
        if(!result.isEmpty()){
            assertTrue(result.get(0).getTotalAllocation() > 0, "Allocation taken out amount should be greater than 0");
            assertEquals(result.get(0).getTotalAllocation() - result.get(0).getAllocationTakenOut(), result.get(0).getAllocationTakenOut(), "Total allocation minus allocation taken out should be equal to total allocation taken out");
        }
    }
}
