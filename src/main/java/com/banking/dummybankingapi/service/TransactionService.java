package com.banking.dummybankingapi.service;

import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.service.base.BaseService;

public interface TransactionService extends BaseService<Long, Transaction> {
    void updateCommentById(Long id, String comment);
}
