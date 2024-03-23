package com.financecalculator.financecalculator.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.financecalculator.financecalculator.dtos.ExpensesDTO;
import com.financecalculator.financecalculator.services.ExpensesService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    
    @Autowired
    private ExpensesService expensesService;

    @PostMapping("/allocateToExpenses")
    public ResponseEntity<List<ExpensesDTO>> expensesAllocation(@RequestBody ExpensesDTO expensesDTO){
        try {
            List<ExpensesDTO> result = expensesService.moneyInExpenses(expensesDTO.getInitialAmount(), expensesDTO.getPercent());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @GetMapping("/getExpenses")
    public ResponseEntity<List<ExpensesDTO>> getExpenses(){
        try {
            List<ExpensesDTO> result = expensesService.getAllExpenses();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PutMapping("/updateExpenses")
    public ResponseEntity<List<ExpensesDTO>> expensesUpdate(@RequestBody ExpensesDTO expenses){
        try {
            List<ExpensesDTO> result = expensesService.moneyOutOfExpenses(expenses.getAllocationTakenOut());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
