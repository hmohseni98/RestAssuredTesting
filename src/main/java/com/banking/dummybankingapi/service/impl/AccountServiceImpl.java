package com.banking.dummybankingapi.service.impl;

import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.repository.AccountRepository;
import com.banking.dummybankingapi.service.AccountService;
import com.banking.dummybankingapi.service.base.BaseServiceImpl;
import com.banking.dummybankingapi.service.dto.AccountRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Long, Account, AccountRepository> implements AccountService {


    protected AccountServiceImpl(ModelMapper modelMapper, AccountRepository repository) {
        super(modelMapper, Account.class, Long.class, repository);
    }
}
