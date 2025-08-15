package com.banking.dummybankingapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/branches/")
public class BranchController {

    @GetMapping
    public ResponseEntity<?> listAllBranches() {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createBranch() {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> readBranch(@PathVariable Long id) {
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBranch(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable Long id) {
        return null;
    }
}
