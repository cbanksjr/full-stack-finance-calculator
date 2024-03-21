package com.financecalculator.financecalculator.services.ServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    /**
     * BigDecimal to round numbers
     *
     * @param value
     * @param places
     * @return
     */
    protected double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    };



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
                throw new IllegalArgumentException("Amount and percent must be greater than 0");
            }

            
            // Calculation
            double amountAllocation = (amount * percent) / 100;
            round(amountAllocation, 2);

            double remaining = amount - amountAllocation;
            round(remaining, 2);

            // Retrieve allocated amounts from repository
            Iterable<Savings> previousAllocations = savingsRepository.findAll();

            // Sum of previous allocations
            double totalPreviousAllocations = 0;
            double takenOut = 0;
            double totalTakenOut = 0;
            for (Savings savings : previousAllocations) {
                totalPreviousAllocations += savings.getAllocatedAmount();

                takenOut += savings.getAllocationTakenOut();

                totalTakenOut += savings.getTotalAllocationTakenOut();
            };      

            // Add the allocated amounts
            double newAllocation = totalPreviousAllocations + amountAllocation;
            round(newAllocation, 2);
            // New savings object to set calculated amounts
            Savings savings = new Savings();
            savings.setInitialAmount(inputAmount);
            round(inputAmount, 2);
            
            savings.setPercent(inputPercent);
            round(inputPercent, 2);
            
            savings.setAllocatedAmount(amountAllocation);
            round(amountAllocation, 2);
            
            savings.setTotalAllocation(newAllocation);
            round(newAllocation, 2);
            
            savings.setAllocationTakenOut(takenOut);
            round(takenOut, 2);
            
            savings.setTotalAllocationTakenOut(totalTakenOut);
            round(totalTakenOut, 2);
            
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
     * Retrieves all savings from the savings repository
     */
    @Override
    public List<SavingsDTO> getAllSavings() {
        //Create ArrayList to store all savings
        List<SavingsDTO> allSavingsList = new ArrayList<>();

        try {
            //Retrieve all savings from the repository and save them to allSavingsList
            Iterable<Savings> allSavings = savingsRepository.findAll();
            for (Savings savings : allSavings) {
                SavingsDTO savingsDTO = modelMapper.map(savings, SavingsDTO.class);
                allSavingsList.add(savingsDTO);
            }
            //Retrieve the last savings from the list and save it to result
            SavingsDTO savingsInfo = allSavingsList.size() > 1 ? allSavingsList.get(allSavingsList.size() - 1) : allSavingsList.get(0);
            List<SavingsDTO> result = new ArrayList<>();
            result.add(savingsInfo);
            return result;

                
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return allSavingsList;
    }



    /*
     * Finds the amount in the savings and subtract the amount that is input
     */

    @Override
    public List<SavingsDTO> moneyOutOfSavings(double amount) {
        //Create ArrayList to store updated savings
        List<SavingsDTO> savingsUpdateList = new ArrayList<>();

        try {
            //Retrieve the allocation from the repository
            Iterable<Savings> moneyInTheSavings = savingsRepository.findAll();
            for (Savings savings : moneyInTheSavings) {
                double allocationTakenOutAmount = amount;

                double newTotalInTheSavings = savings.getTotalAllocation() - allocationTakenOutAmount;

                double totalTakenOut = allocationTakenOutAmount + savings.getTotalAllocationTakenOut();

                //Update the allocation taken out and total allocation taken out
                savings.setAllocationTakenOut(allocationTakenOutAmount);
                round(allocationTakenOutAmount, 2);
                savings.setTotalAllocation(newTotalInTheSavings);
                round(newTotalInTheSavings, 2);
                savings.setTotalAllocationTakenOut(totalTakenOut);
                round(totalTakenOut, 2);

                //If the total allocation is less than 0, delete the allocation and continue to the next allocation
                if(savings.getTotalAllocation() < 0){
                    savingsRepository.delete(savings);
                    continue;
                }

                //Save the updated allocation to the repository
                savingsRepository.save(savings);

                //Turn the updated allocation into a savingsDTO
                SavingsDTO savingsDTO = modelMapper.map(savings, SavingsDTO.class);
                savingsUpdateList.add(savingsDTO);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return savingsUpdateList;
    }


    
}
