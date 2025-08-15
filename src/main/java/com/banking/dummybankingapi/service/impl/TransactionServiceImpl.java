package com.banking.dummybankingapi.service.impl;

import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.repository.TransactionRepository;
import com.banking.dummybankingapi.service.TransactionService;
import com.banking.dummybankingapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Transaction, TransactionRepository> implements TransactionService {

    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }
}
