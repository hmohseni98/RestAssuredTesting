package com.banking.dummybankingapi.controller;

import com.banking.dummybankingapi.facade.AccountFacade;
import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.service.AccountService;
import com.banking.dummybankingapi.service.dto.AccountRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts/")
@RequiredArgsConstructor
public class AccountController {

    private final ModelMapper modelMapper;

    private final AccountFacade accountFacade;

    @GetMapping
    public ResponseEntity<List<Account>> listAllAccounts() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody AccountRequestDto requestDto) {
        accountFacade.createAccount(requestDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> readAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateAccount(@PathVariable Long id, @RequestBody AccountRequestDto requestDto) {
        accountService.update(id, requestDto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Account convertAccountDtoToEntity(AccountRequestDto requestDto) {
        return modelMapper.map(requestDto, Account.class);
    }

}
