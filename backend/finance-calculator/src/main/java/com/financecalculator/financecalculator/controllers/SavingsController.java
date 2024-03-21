package com.financecalculator.financecalculator.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financecalculator.financecalculator.dtos.SavingsDTO;
import com.financecalculator.financecalculator.models.Savings;
import com.financecalculator.financecalculator.services.SavingsService;



@RestController
@RequestMapping("/api/savings")
public class SavingsController {
    
    @Autowired
    private SavingsService savingsService;


    @PostMapping("/allocateToSavings")
    public ResponseEntity<List<SavingsDTO>> savingsAllocation(@RequestBody SavingsDTO savingsDTO){
        try {
            List<SavingsDTO> result = savingsService.moneyInSavings(savingsDTO.getInitialAmount(), savingsDTO.getPercent());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @GetMapping("/getSavings")
    public ResponseEntity<List<SavingsDTO>> getSavings(){
        try {
            List<SavingsDTO> result = savingsService.getAllSavings();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
    
    @PutMapping("/updateSavings")
    public ResponseEntity<List<SavingsDTO>> savingsUpdate(@RequestBody Savings savings){
        try {
            List<SavingsDTO> result = savingsService.moneyOutOfSavings(savings.getAllocationTakenOut());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
