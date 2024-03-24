package com.financecalculator.financecalculator.services.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.financecalculator.financecalculator.dtos.VacationDTO;
import com.financecalculator.financecalculator.models.Account;
import com.financecalculator.financecalculator.models.Vacation;
import com.financecalculator.financecalculator.repositories.AccountRepository;
import com.financecalculator.financecalculator.repositories.VacationRepository;
import com.financecalculator.financecalculator.services.RoundingService;
import com.financecalculator.financecalculator.services.VacationService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class VacationServiceImpl implements VacationService{

    private ModelMapper modelMapper;
    private VacationRepository vacationRepository;
    private AccountRepository accountRepository;
    private RoundingService roundingService;

    /*
     * Calculates an amount to add to vacation allocation and saves it to vacation
     * respository and saves amount and remaining to account repository
     */
    @Override
    public List<VacationDTO> moneyForVacation(double amount, double percent) {
        
        //Create ArrayList to store vacation info
        List<VacationDTO> vacationDTOList = new ArrayList<>();

        try {
            double inputAmount = amount, inputPercent = percent;

            if (inputAmount <= 0 || inputPercent <= 0) {
                throw new IllegalArgumentException("Amount and percent must be greater than 0");
            }

            // Calculation
            BigDecimal amountAllocation = roundingService.round((amount * percent) / 100, 2);

            BigDecimal remaining = roundingService.round(amount - amountAllocation.doubleValue(), 2);

            // Retrieve allocated amounts from repository
            Iterable<Vacation> previousAllocations = vacationRepository.findAll();

            // Sum of previous allocations
            double totalPreviousAllocations = 0;
            double takenOut = 0;
            double totalTakenOut = 0;
            for (Vacation vacation : previousAllocations) {
                totalPreviousAllocations += vacation.getAllocatedAmount();
                takenOut += vacation.getAllocationTakenOut();
                totalTakenOut += vacation.getAllocationTakenOut();
            }

            // Add the allocated amounts
            BigDecimal newAllocation = roundingService.round(amountAllocation.doubleValue() + totalPreviousAllocations, 2);

            // New vacation object to set calculated amounts
            Vacation vacation = new Vacation();
            vacation.setInitialAmount(roundingService.round(inputAmount,2).doubleValue());
            vacation.setPercent(roundingService.round(inputPercent, 2).doubleValue());
            vacation.setAllocatedAmount(roundingService.round(amountAllocation.doubleValue(), 2).doubleValue());
            vacation.setTotalAllocation(roundingService.round(newAllocation.doubleValue(), 2).doubleValue());
            vacation.setAllocationTakenOut(roundingService.round(takenOut, 2).doubleValue());
            vacation.setTotalAllocationTakenOut(roundingService.round(totalTakenOut, 2).doubleValue());

            // Put vacation object in repository
            vacationRepository.save(vacation);

            // Turn vacation model into vacationDTO model
            VacationDTO vacationDTO = modelMapper.map(vacation, VacationDTO.class);

            // Add vacationDTO to vacationDTOList
            vacationDTOList.add(vacationDTO);

            // Add elements from vactionDTOList to account repository
            Account account = new Account();
            account.setAmount(inputAmount);
            double remainingValue = remaining.doubleValue();
            account.setRemaining(remainingValue);
            double amountAllocationValue = amountAllocation.doubleValue();
            account.setDeducted(amountAllocationValue);

            accountRepository.save(account);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return vacationDTOList;
    }

    /*
     * Retrieves all vacation allocations
     */
    @Override
    public List<VacationDTO> getAllVacation() {
        //Create ArrayList to store all savings
        List<VacationDTO> allVacationList = new ArrayList<>();

        try {
            //Retrieve all vacation allocations
            Iterable<Vacation> allVacation = vacationRepository.findAll();

            //Convert vacation model to vacationDTO model
            for (Vacation vacation : allVacation) {
                VacationDTO vacationDTO = modelMapper.map(vacation, VacationDTO.class);
                allVacationList.add(vacationDTO);
            }

            //Retrieve the last vacation allocation from the list and save it to result
            VacationDTO vacationInfo = allVacationList.size() > 1 ? allVacationList.get(allVacationList.size() - 1) : allVacationList.get(0);
            List<VacationDTO> result = new ArrayList<>();
            result.add(vacationInfo);
            return result; 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return allVacationList;
    }

    @Override
    public List<VacationDTO> moneyOutOfVacation(double amount) {
        //Create ArrayList to store updated vacation
        List<VacationDTO> vacationUpdateList = new ArrayList<>();

        try {
            //Retrieve all vacation allocations
            Iterable<Vacation> moneyForVacation = vacationRepository.findAll();

            for (Vacation vacations : moneyForVacation){
                BigDecimal allocationTakenOutAmount = roundingService.round(amount, 2);

                if(allocationTakenOutAmount.doubleValue() <= 0) {
                    throw new IllegalArgumentException("Amount must be greater than 0");
                }

                BigDecimal newTotalInVacation = roundingService.round(vacations.getTotalAllocation() - allocationTakenOutAmount.doubleValue(), 2);

                BigDecimal totalTakenOut = roundingService.round(allocationTakenOutAmount.doubleValue() + vacations.getTotalAllocationTakenOut(), 2);

                //update the vacation allocation
                vacations.setTotalAllocation(newTotalInVacation.doubleValue());
                vacations.setAllocationTakenOut(allocationTakenOutAmount.doubleValue());
                vacations.setTotalAllocationTakenOut(totalTakenOut.doubleValue());

                //If the total allocation is less than 0, delete the allocation and continue to the next allocation
                if(vacations.getTotalAllocation() < 0) {
                    vacationRepository.delete(vacations);
                    continue;
                }

                //Save the updated vacation allocation
                vacationRepository.save(vacations);

                //Turn the updated vacation allocation into a vacationDTO
                VacationDTO vacationDTO = modelMapper.map(vacations, VacationDTO.class);
                vacationUpdateList.add(vacationDTO);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return vacationUpdateList;
    }
    
}
