package com.banking.dummybankingapi.service.impl;

import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.repository.TransactionRepository;
import com.banking.dummybankingapi.service.TransactionService;
import com.banking.dummybankingapi.service.base.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Long, Transaction, TransactionRepository> implements TransactionService {

    protected TransactionServiceImpl(ModelMapper modelMapper, TransactionRepository repository) {
        super(modelMapper, Transaction.class, Long.class, repository);
    }

    @Transactional
    @Override
    public void updateCommentById(Long id, String comment) {
        repository.updateCommentById(id, comment);
    }
}
