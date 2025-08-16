package com.banking.dummybankingapi.facade;

import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.model.Branch;
import com.banking.dummybankingapi.service.AccountService;
import com.banking.dummybankingapi.service.BranchService;
import com.banking.dummybankingapi.service.dto.AccountRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountFacade {
    private final AccountService accountService;
    private final ModelMapper modelMapper;
    private final BranchService branchService;

    public void createAccount(AccountRequestDto requestDto) {
        Branch branch = branchService.findByCode(requestDto.getBranchCode());
        Account account = modelMapper.map(requestDto, Account.class);
        account.setBranch(branch);
        accountService.save(account);

    }
}
