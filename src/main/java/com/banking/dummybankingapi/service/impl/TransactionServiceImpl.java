package com.banking.dummybankingapi.service.impl;

import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.repository.TransactionRepository;
import com.banking.dummybankingapi.service.TransactionService;
import com.banking.dummybankingapi.service.base.BaseServiceImpl;
import com.banking.dummybankingapi.service.dto.TransactionRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Long, Transaction,TransactionRepository> implements TransactionService {


    protected TransactionServiceImpl(ModelMapper modelMapper, TransactionRepository repository) {
        super(modelMapper, Transaction.class, Long.class, repository);
    }
}
