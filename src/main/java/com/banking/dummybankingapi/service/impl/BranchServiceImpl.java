package com.banking.dummybankingapi.service.impl;

import com.banking.dummybankingapi.model.Branch;
import com.banking.dummybankingapi.repository.BranchRepository;
import com.banking.dummybankingapi.service.BranchService;
import com.banking.dummybankingapi.service.base.BaseService;
import com.banking.dummybankingapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl extends BaseServiceImpl<Branch, BranchRepository> implements BranchService {

    public BranchServiceImpl(BranchRepository repository) {
        super(repository);
    }
}
