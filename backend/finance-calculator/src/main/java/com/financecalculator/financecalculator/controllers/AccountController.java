package com.financecalculator.financecalculator.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.financecalculator.financecalculator.dtos.AccountDTO;
import com.financecalculator.financecalculator.services.AccountService;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/account")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    //ADD POST MAPPING TO POST DATA RECEIVED FROM USER

    @GetMapping("/setAmount/{id}")
    public ResponseEntity<?> saveAmount(@PathVariable long id){
        try {
            List<AccountDTO> result = accountService.amountToAllocateFrom(id);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/updateAmount")
    public ResponseEntity<?> updateAmount() {
        try {
            List<AccountDTO> result = accountService.iterateIds();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

}
