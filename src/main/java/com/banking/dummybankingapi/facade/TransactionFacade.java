package com.banking.dummybankingapi.facade;

import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.service.AccountService;
import com.banking.dummybankingapi.service.TransactionService;
import com.banking.dummybankingapi.service.dto.TransactionRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionFacade {

    private final TransactionService transactionService;
    private final AccountService accountService;

    private final ModelMapper modelMapper;

    public List<Transaction> listAllTransactions() {
        return transactionService.findAll();
    }

    public void createTransaction(TransactionRequestDto requestDto) {
        Account from = accountService.findById(requestDto.getAccountIdFrom());
        Account to = accountService.findById(requestDto.getAccountIdTo());
        Transaction transaction = modelMapper.map(requestDto, Transaction.class);
        transaction.setAccountFrom(from);
        transaction.setAccountTo(to);

        transactionService.save(transaction);
    }

    public Transaction readTransaction(Long id) {
        return transactionService.findById(id);
    }

    public void updateTransaction(Long id, TransactionRequestDto requestDto) {
        Transaction transaction = modelMapper.map(requestDto, Transaction.class);
        transaction.setId(id);

        if (requestDto.getAccountIdFrom() != null) {
            transaction.setAccountFrom(accountService.findById(requestDto.getAccountIdFrom()));
        }
        if (requestDto.getAccountIdTo() != null) {
            transaction.setAccountTo(accountService.findById(requestDto.getAccountIdTo()));
        }

        transactionService.update(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionService.delete(id);
    }
}
