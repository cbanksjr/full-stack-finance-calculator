package com.fullstackfinance.financecalculator.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fullstackfinance.financecalculator.dtos.FinancesDTO;
import com.fullstackfinance.financecalculator.models.Finances;
import com.fullstackfinance.financecalculator.repositories.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FinancesServiceImpl implements FinancesService {

    private FinancesRepository financesRepository;
    private ModelMapper modelMapper;
    private Finances finances;

    @Override
    public FinancesDTO addedAmount() {
        double moneyToBeDeductedFrom = finances.getAmount();
        try{
            if(moneyToBeDeductedFrom <= 0){
                throw new IllegalArgumentException();
            }
            financesRepository.save(moneyToBeDeductedFrom);
            return modelMapper.map(finances, FinancesDTO.class);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            finances.setAmount(0);
            return null;
        } 
    }

    @Override
    public double deductedAmount() {
        double 
    }

    @Override
    public double remainingAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remainingAmount'");
    }

    @Override
    public double total() {
        // TODO Auto-generated method stub
        return 0;
    }

}
