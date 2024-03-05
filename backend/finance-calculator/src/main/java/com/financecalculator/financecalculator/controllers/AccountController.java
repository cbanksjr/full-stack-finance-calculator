package com.financecalculator.financecalculator.controllers;


import java.util.Collections;
import java.util.List;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.financecalculator.financecalculator.dtos.AccountDTO;
import com.financecalculator.financecalculator.services.AccountService;



@RestController
@RequestMapping("/api/account")
public class AccountController {
    
    @Autowired
    private AccountService accountService;
    
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/updateAmount")
    public ResponseEntity<List<AccountDTO>> updateAmount() {
        try {
            List<AccountDTO> result = accountService.retrieveAmounts();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Failed to update amount: {}", e.getMessage(), e);
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
    }
    

}
