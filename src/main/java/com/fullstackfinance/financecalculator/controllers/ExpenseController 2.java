package com.fullstackfinance.financecalculator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullstackfinance.financecalculator.dtos.ExpensesDTO;
import com.fullstackfinance.financecalculator.services.ExpensesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private ExpensesService expensesService;

    @PostMapping("/setAllocation/{id}")
    public ResponseEntity<?> financeAllocation(@PathVariable long id){
        try {
            ExpensesDTO result = expensesService.financeAllocation(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
