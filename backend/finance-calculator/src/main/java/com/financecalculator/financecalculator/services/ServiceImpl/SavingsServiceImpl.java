package com.financecalculator.financecalculator.services.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.financecalculator.financecalculator.dtos.SavingsDTO;
import com.financecalculator.financecalculator.models.Account;
import com.financecalculator.financecalculator.models.Savings;
import com.financecalculator.financecalculator.repositories.AccountRepository;
import com.financecalculator.financecalculator.repositories.SavingsRepository;
import com.financecalculator.financecalculator.services.SavingsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SavingsServiceImpl implements SavingsService {

    private ModelMapper modelMapper;
    private SavingsRepository savingsRepository;
    private AccountRepository accountRepository;

    /*
     * Calculates an amount to add to savings allocation and saves it to savings
     * respository and saves amount and remaining to account repository
     */
    @Override
    public List<SavingsDTO> moneyInSavings(double amount, double percent) {

        // Create ArrayList to store savings info
        List<SavingsDTO> savingsDTOList = new ArrayList<>();

        try {
            double inputAmount = amount, inputPercent = percent;

            if (inputAmount <= 0 || inputPercent <= 0) {
                throw new IllegalArgumentException("Input must be greater than 0");
            }

            // Calculation
            double amountAllocation = amount * (percent / 100);
            double remaining = amount - amountAllocation;

            // Retrieve allocated amounts from repository
            Iterable<Savings> previousAllocations = savingsRepository.findAll();

            // Sum of previous allocations
            double totalPreviousAllocations = 0.0;
            for (Savings savings : previousAllocations) {
                totalPreviousAllocations += savings.getAllocatedAmount();
            }
            ;

            // Add the allocated amounts
            double newAllocation = totalPreviousAllocations + amountAllocation;

            // New savings object to set calculated amounts
            Savings savings = new Savings();
            savings.setInitialAmount(inputAmount);
            savings.setPercent(inputPercent);
            savings.setAllocatedAmount(amountAllocation);
            savings.setTotalAllocation(newAllocation);
            // savings.setAmountRemaining(remaining);

            // Put savings object into savings repository
            savingsRepository.save(savings);
            // Turn savings model into savingsDTO model
            SavingsDTO savingsDTO = modelMapper.map(savings, SavingsDTO.class);

            // Add savingsDTO to ArrayList
            savingsDTOList.add(savingsDTO);

            // Add elements from savings calculation to account repository
            Account account = new Account();
            account.setAmount(inputAmount);
            account.setRemaining(remaining);
            account.setDeducted(amountAllocation);
            accountRepository.save(account);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return savingsDTOList;
    }

    /*
     * Finds the amount in the savings and subtract the amount that is input
     */

    @Override
    public SavingsDTO moneyOutOfSavings(double amount, long allocationId) {
        SavingsDTO savingsUpdate = new SavingsDTO();
        try {
            Savings targetAllocation = null;
            Iterable<Savings> moneyInTheSavings = savingsRepository.findAll();
            allocationId = 0;
            double totalAllocationTakenOut = 0.0;
            for (Savings savings : moneyInTheSavings) {
                totalAllocationTakenOut += savings.getAllocationTakenOut();
                allocationId++;
                if (savings.getId() == allocationId) {
                    targetAllocation = savings;
                }
            }

            if (targetAllocation != null) {
                double allocationTakenOutAmount = amount;
                double newTotalInTheSavings = targetAllocation.getTotalAllocation() - allocationTakenOutAmount;
                double totalTakenOut = totalAllocationTakenOut + allocationTakenOutAmount;

                targetAllocation.setAllocationTakenOut(allocationTakenOutAmount);
                targetAllocation.setTotalAllocation(newTotalInTheSavings);
                targetAllocation.setTotalAllocationTakenOut(totalTakenOut);

                savingsRepository.save(targetAllocation);

                savingsUpdate = modelMapper.map(targetAllocation, SavingsDTO.class);
            } else {
                System.err.println("Allocation not found");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return savingsUpdate;
    }
}
