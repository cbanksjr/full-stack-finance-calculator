// package com.fullstackfinance.financecalculator.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.fullstackfinance.financecalculator.services.FinancesService;


// @RestController
// @RequestMapping("/finance")
// public class FinanceController {

//     @Autowired
//     private FinancesService financesService;

//     @PostMapping("/addamount")
//     public ResponseEntity<?> add(){
//         try {
//             return ResponseEntity.ok(financesService.addedAmount());
//         } catch (Exception e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }

// }
