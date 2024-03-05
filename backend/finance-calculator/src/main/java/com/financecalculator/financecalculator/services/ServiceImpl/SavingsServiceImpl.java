package com.financecalculator.financecalculator.services.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.financecalculator.financecalculator.dtos.SavingsDTO;
import com.financecalculator.financecalculator.models.Savings;
import com.financecalculator.financecalculator.repositories.SavingsRepository;
import com.financecalculator.financecalculator.services.SavingsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SavingsServiceImpl implements SavingsService {

    private ModelMapper modelMapper;
    private SavingsRepository savingsRepository;

    @Override
    public List<SavingsDTO> moneyInSavings(double amount, double percent) {

        List<SavingsDTO> savingsDTOList = new ArrayList<>();

        try {
            double inputAmount = amount, inputPercent = percent;

            if(inputAmount < 0 || inputPercent < 0){
                throw new IllegalArgumentException("Input must be greater than 0");
            }
            double amountAllocation = amount * (percent / 100);
            double remaining = amount - amountAllocation;

            Savings savings = new Savings();
            savings.setInitialAmount(inputAmount);
            savings.setPercent(inputPercent);
            savings.setAllocatedAmount(amountAllocation);
            savings.setAmountRemaining(remaining);
            
            savingsRepository.save(savings);
            //SAVE INPUT AMOUNT TO ACCOUNT REPOSITORY!!!
            SavingsDTO savingsDTO = modelMapper.map(savings, SavingsDTO.class);

            savingsDTOList.add(savingsDTO);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return savingsDTOList;
    }
}
