package com.banking.dummybankingapi.facade;

import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.service.AccountService;
import com.banking.dummybankingapi.service.TransactionService;
import com.banking.dummybankingapi.service.dto.TransactionRequestDto;
import com.banking.dummybankingapi.service.dto.TransactionUpdateRequestDto;
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

    public Transaction createTransaction(TransactionRequestDto requestDto) {
        Transaction transaction = modelMapper.map(requestDto, Transaction.class);

        return transactionService.save(transaction);
    }

    public Transaction readTransaction(Long id) {
        return transactionService.findById(id);
    }

    public void updateComment(Long id, TransactionUpdateRequestDto requestDto) {
        transactionService.updateCommentById(id, requestDto.getComment());
    }

    public void deleteTransaction(Long id) {
        transactionService.delete(id);
    }
}
