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

import com.financecalculator.financecalculator.dtos.VacationDTO;
import com.financecalculator.financecalculator.services.VacationService;

@RestController
@RequestMapping("/api/vacation")
public class VacationController {
    
    @Autowired
    private VacationService vacationService;

    @PostMapping("/allocateToVacation")
    public ResponseEntity<List<VacationDTO>> vacationAllocation(@RequestBody VacationDTO vacationDTO){
        try {
            List<VacationDTO> result = vacationService.moneyForVacation(vacationDTO.getInitialAmount(), vacationDTO.getPercent());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @GetMapping("/getVacation")
    public ResponseEntity<List<VacationDTO>> getVacation(){
        try {
            List<VacationDTO> result = vacationService.getAllVacation();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PutMapping("/updateVacation")
    public ResponseEntity<List<VacationDTO>> vacationUpdate(@RequestBody VacationDTO vacationDTO){
        try {
            List<VacationDTO> result = vacationService.moneyOutOfVacation(vacationDTO.getAllocationTakenOut());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
