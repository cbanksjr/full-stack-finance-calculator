package com.fullstackfinance.financecalculator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;
import com.fullstackfinance.financecalculator.services.AccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountController {
    
    private AccountService accountService;

    @PostMapping("/setAmount")
    public ResponseEntity<?> saveAmount(@RequestBody String moneyToBeDeductedFrom){
        try {
            AccountDTO result = accountService.setAmountToDeductFrom(moneyToBeDeductedFrom);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/setAmount")
    public ResponseEntity<?> getRemainingAfterDeductions(@RequestBody String setAmountToDeductFrom, @RequestBody String getAmountAfterDeductions, @RequestBody String moneyToBeDeductedFrom){
        try {
            AccountDTO result = accountService.setAmountRemaining(setAmountToDeductFrom, getAmountAfterDeductions);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
