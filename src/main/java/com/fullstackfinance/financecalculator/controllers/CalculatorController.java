package com.fullstackfinance.financecalculator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullstackfinance.financecalculator.dtos.CalculatorDTO;
import com.fullstackfinance.financecalculator.services.CalculatorService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CalculatorController {

    private CalculatorService calculatorService;

    @PostMapping("/calculator")
    public ResponseEntity<?> calculate(@RequestBody CalculatorDTO calculatorDTO){
        try {
            CalculatorDTO result = calculatorService.addToAccount(calculatorDTO.getAmount());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // @PostMapping("/calculatorDeduct")
    // public ResponseEntity<?> deduct(@RequestBody CalculatorDTO calculatorDTO){
    //     try {
    //         CalculatorDTO result = calculatorService.addToAccount(calculatorDTO.getAmount());
    //         return ResponseEntity.ok(result);
    //     } catch (Exception e) {
    //         return ResponseEntity.badRequest().body(e.getMessage());
    //     }
    // }

}
