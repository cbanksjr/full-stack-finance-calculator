package com.financecalculator.financecalculator.services.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.financecalculator.financecalculator.dtos.ExpensesDTO;
import com.financecalculator.financecalculator.models.Account;
import com.financecalculator.financecalculator.models.Expenses;
import com.financecalculator.financecalculator.repositories.AccountRepository;
import com.financecalculator.financecalculator.repositories.ExpensesRepository;
import com.financecalculator.financecalculator.services.ExpensesService;
import com.financecalculator.financecalculator.services.RoundingService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ExpensesServiceImpl implements ExpensesService {

    private ModelMapper modelMapper;
    private ExpensesRepository expensesRepository;
    private AccountRepository accountRepository;
    private RoundingService roundingService;

    /*
     * Calculates an amount to add to expenses allocation and saves it to expenses
     * respository and saves amount and remaining to account repository
     */
    @Override
    public List<ExpensesDTO> moneyInExpenses(double amount, double percent) {

        // Create ArrayList to store expenses info
        List<ExpensesDTO> expensesDTOList = new ArrayList<>();

        try {
            double inputAmount = amount, inputPercent = percent;
            if (inputAmount <= 0 || inputPercent <= 0) {
                throw new IllegalArgumentException("Amount and percent must be greater than 0");
            }
            ;

            // Calculation
            BigDecimal amountAllocation = roundingService.round((amount * percent) / 100, 2);
            BigDecimal remaining = roundingService.round(amount - amountAllocation.doubleValue(), 2);

            // Retrieve allocated amounts from repository
            Iterable<Expenses> previousAllocations = expensesRepository.findAll();

            // Sum of previous allocations
            double totalPreviousAllocations = 0;
            double takenOut = 0;
            double totalTakenOut = 0;
            for (Expenses expenses : previousAllocations) {
                totalPreviousAllocations += expenses.getAllocatedAmount();
                takenOut += expenses.getAllocationTakenOut();
                totalTakenOut += expenses.getTotalAllocationTakenOut();
            }
            ;

            // Add the allocated amounts
            BigDecimal newAllocation = roundingService.round(totalPreviousAllocations + amountAllocation.doubleValue(),
                    2);

            // New expenses object to set calculated amounts
            Expenses expenses = new Expenses();
            expenses.setInitialAmount(roundingService.round(inputAmount, 2).doubleValue());
            expenses.setPercent(roundingService.round(inputPercent, 2).doubleValue());
            expenses.setAllocatedAmount(roundingService.round(amountAllocation.doubleValue(), 2).doubleValue());
            expenses.setTotalAllocation(roundingService.round(newAllocation.doubleValue(), 2).doubleValue());
            expenses.setAllocationTakenOut(roundingService.round(takenOut, 2).doubleValue());
            expenses.setTotalAllocationTakenOut(roundingService.round(totalTakenOut, 2).doubleValue());

            // Put expenses object into expenses repository
            expensesRepository.save(expenses);

            // Convert expenses object to expensesDTO object
            ExpensesDTO expensesDTO = modelMapper.map(expenses, ExpensesDTO.class);

            // Add expensesDTO object to expensesDTOList
            expensesDTOList.add(expensesDTO);

            // Add calculations to account repository
            Account account = new Account();
            account.setAmount(inputAmount);
            double remainingValue = remaining.doubleValue(); // Convert remaining to double
            account.setRemaining(remainingValue);
            double amountAllocationValue = amountAllocation.doubleValue(); // Convert amountAllocation to double
            account.setDeducted(amountAllocationValue);

            accountRepository.save(account);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return expensesDTOList;
    }

    /*
     * Retrieves all expenses from expenses repository
     */
    @Override
    public List<ExpensesDTO> getAllExpenses() {
        // Create ArrayList to store expenses info
        List<ExpensesDTO> allExpensesList = new ArrayList<>();

        try {
            // Retrieve all expenses from expenses repository
            Iterable<Expenses> expenses = expensesRepository.findAll();

            // Convert expenses to expensesDTO
            for (Expenses expense : expenses) {
                ExpensesDTO expensesDTO = modelMapper.map(expense, ExpensesDTO.class);
                allExpensesList.add(expensesDTO);
            }

            // Retrieve the last expenses from the list and save it to result
            ExpensesDTO expensesInfo = allExpensesList.size() > 1 ? allExpensesList.get(allExpensesList.size() - 1)
                    : allExpensesList.get(0);
            List<ExpensesDTO> result = new ArrayList<>();
            result.add(expensesInfo);
            return result;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return allExpensesList;
    }

    /**
     * Finds the amount in expenses and subtracts the amount that is inputed
     */
    @Override
    public List<ExpensesDTO> moneyOutOfExpenses(double amount) {
         //Create ArrayList to store updated savings
        List<ExpensesDTO> expensesUpdateList = new ArrayList<>();

        try {
            //Retrieve the allocation from the repository
            Iterable<Expenses> moneyInExpenses = expensesRepository.findAll();
            for (Expenses expenses : moneyInExpenses) {
                BigDecimal allocationTakenOutAmount = roundingService.round(amount, 2);

                if(allocationTakenOutAmount.doubleValue() <= 0){
                    throw new IllegalArgumentException("Amount must be greater than 0");
                }

                BigDecimal newTotalInTheSavings = roundingService.round(expenses.getTotalAllocation() - allocationTakenOutAmount.doubleValue(),2);

                BigDecimal totalTakenOut = roundingService.round(allocationTakenOutAmount.doubleValue() + expenses.getTotalAllocationTakenOut(),2);

                //Update the allocation taken out and total allocation taken out
                expenses.setAllocationTakenOut(allocationTakenOutAmount.doubleValue());
                expenses.setTotalAllocation(newTotalInTheSavings.doubleValue());
                expenses.setTotalAllocationTakenOut(totalTakenOut.doubleValue());

                //If the total allocation is less than 0, delete the allocation and continue to the next allocation
                if(expenses.getTotalAllocation() < 0){
                    expensesRepository.delete(expenses);
                    continue;
                }

                //Save the updated allocation to the repository
                expensesRepository.save(expenses);

                //Turn the updated allocation into a savingsDTO
                ExpensesDTO expensesDTO = modelMapper.map(expenses, ExpensesDTO.class);
                expensesUpdateList.add(expensesDTO);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return expensesUpdateList;
    }

    }


