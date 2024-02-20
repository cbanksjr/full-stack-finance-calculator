package com.fullstackfinance.financecalculator.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullstackfinance.financecalculator.dtos.ExpensesDTO;
import com.fullstackfinance.financecalculator.services.ExpensesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    private ExpensesService expensesService;

    @PostMapping("/setAllocation/{id}")
    public ResponseEntity<?> financeAllocation(@PathVariable long id, @RequestBody ExpensesDTO expensesDTO){
        try {
            List<ExpensesDTO> result = expensesService.expenseAllocation(id, expensesDTO.getPercent());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
