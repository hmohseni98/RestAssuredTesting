package com.banking.dummybankingapi.service.impl;

import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.repository.AccountRepository;
import com.banking.dummybankingapi.service.AccountService;
import com.banking.dummybankingapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountRepository> implements AccountService {

    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }
}
