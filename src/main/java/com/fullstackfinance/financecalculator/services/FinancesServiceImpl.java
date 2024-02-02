package com.fullstackfinance.financecalculator.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fullstackfinance.financecalculator.repositories.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FinancesServiceImpl implements FinancesService{

    private FinancesRepository financesRepository;
    private ModelMapper modelMapper;


    @Override
    public double addedAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addedAmount'");
    }

    @Override
    public double deductedAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deductedAmount'");
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
