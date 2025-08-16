package com.banking.dummybankingapi.service;

import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.service.base.BaseService;
import com.banking.dummybankingapi.service.dto.TransactionRequestDto;

public interface TransactionService extends BaseService<Long, Transaction> {
}
