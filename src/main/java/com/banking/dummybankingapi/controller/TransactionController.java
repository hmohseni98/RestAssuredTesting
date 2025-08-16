package com.banking.dummybankingapi.controller;

import com.banking.dummybankingapi.facade.TransactionFacade;
import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.service.dto.ResponseDto;
import com.banking.dummybankingapi.service.dto.TransactionRequestDto;
import com.banking.dummybankingapi.service.dto.TransactionUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/transactions/")
public class TransactionController {

    private final TransactionFacade transactionFacade;

    @GetMapping
    public ResponseEntity<List<Transaction>> listAllTransactions() {
        return ResponseEntity.ok(transactionFacade.listAllTransactions());
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequestDto requestDto) {
        return ResponseEntity.ok(transactionFacade.createTransaction(requestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<Transaction> readTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(transactionFacade.readTransaction(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateTransaction(@PathVariable Long id, @RequestBody TransactionUpdateRequestDto transactionRequestDto) {
        transactionFacade.updateComment(id, transactionRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionFacade.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

}
