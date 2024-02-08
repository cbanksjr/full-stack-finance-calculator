package com.fullstackfinance.financecalculator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullstackfinance.financecalculator.dtos.CalculatorDTO;
import com.fullstackfinance.financecalculator.services.CalculatorService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {

    private CalculatorService calculatorService;

    @PostMapping()
    public ResponseEntity<?> calculate(@RequestBody CalculatorDTO calculatorDTO){
        try {
            CalculatorDTO result = calculatorService.calculate(calculatorDTO.getAmount(), calculatorDTO.getPercent());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
