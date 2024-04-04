package com.financecalculator.financecalculator.services.ServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.financecalculator.financecalculator.services.RoundingService;

@Service
public class RoundingServiceImpl implements RoundingService{

    @Override
    public BigDecimal round(double value, int places) {
        if(places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd;
    }
    
}
