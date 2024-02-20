package com.fullstackfinance.financecalculator.controllers;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullstackfinance.financecalculator.dtos.AccountDTO;
import com.fullstackfinance.financecalculator.services.AccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    
    private AccountService accountService;

    @GetMapping("/setAmount/{id}")
    public ResponseEntity<?> saveAmount(@PathVariable long id){
        try {
            ArrayList<AccountDTO> result = accountService.amountToAllocateFrom(id);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
