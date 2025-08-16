package com.banking.dummybankingapi.service.impl;

import com.banking.dummybankingapi.model.Branch;
import com.banking.dummybankingapi.repository.BranchRepository;
import com.banking.dummybankingapi.service.BranchService;
import com.banking.dummybankingapi.service.base.BaseServiceImpl;
import com.banking.dummybankingapi.service.dto.BranchRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl extends BaseServiceImpl<Long, Branch, BranchRepository> implements BranchService {

    private final BranchRepository branchRepository;

    protected BranchServiceImpl(ModelMapper modelMapper, BranchRepository repository) {
        super(modelMapper, Branch.class, Long.class, repository);
        this.branchRepository = repository;
    }

    @Override
    public Branch findByCode(Integer code) {
        return branchRepository.findByCode(code);
    }
}
