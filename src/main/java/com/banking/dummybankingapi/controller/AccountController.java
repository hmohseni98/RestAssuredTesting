package com.banking.dummybankingapi.controller;

import com.banking.dummybankingapi.facade.AccountFacade;
import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.service.dto.AccountRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountFacade accountFacade;

    @GetMapping
    public ResponseEntity<List<Account>> listAllAccounts() {
        return ResponseEntity.ok(accountFacade.listAllAccounts());
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody AccountRequestDto requestDto) {
        accountFacade.createAccount(requestDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> readAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountFacade.readAccount(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateAccount(@PathVariable Long id, @RequestBody AccountRequestDto requestDto) {
        accountFacade.updateAccount(id, requestDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountFacade.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
