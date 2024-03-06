package com.financecalculator.financecalculator.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financecalculator.financecalculator.dtos.SavingsDTO;
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
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
    } 
}
