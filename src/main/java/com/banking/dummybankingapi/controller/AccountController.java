package com.banking.dummybankingapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts/")
public class AccountController {

    @GetMapping
    public ResponseEntity<?> listAllAccounts() {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createAccount() {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> readAccount(@PathVariable Long id) {
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        return null;
    }

}
