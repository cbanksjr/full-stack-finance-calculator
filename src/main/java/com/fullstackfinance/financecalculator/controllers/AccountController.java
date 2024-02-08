package com.fullstackfinance.financecalculator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;
import com.fullstackfinance.financecalculator.services.AccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {
    
    private AccountService accountService;

    @PostMapping("/setAmount/{id}")
    public ResponseEntity<?> saveAmount(@PathVariable long id){
        try {
            AccountDTO result = accountService.amountToAllocateFrom(id);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
