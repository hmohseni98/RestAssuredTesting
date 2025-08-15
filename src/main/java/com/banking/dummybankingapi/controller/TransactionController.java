package com.banking.dummybankingapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transactions/")
public class TransactionController {

    @GetMapping
    public ResponseEntity<?> listAllTransactions(){
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(){
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> readTransaction(@PathVariable Long id){
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id){
        return null;
    }

}
