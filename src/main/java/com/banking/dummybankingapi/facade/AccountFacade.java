package com.banking.dummybankingapi.facade;

import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.model.Branch;
import com.banking.dummybankingapi.service.AccountService;
import com.banking.dummybankingapi.service.BranchService;
import com.banking.dummybankingapi.service.dto.AccountRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountService accountService;
    private final ModelMapper modelMapper;
    private final BranchService branchService;

    public List<Account> listAllAccounts() {
        return accountService.findAll();
    }

    public void createAccount(AccountRequestDto requestDto) {
        Branch branch = branchService.findByCode(requestDto.getBranchCode());
        Account account = modelMapper.map(requestDto, Account.class);
        account.setBranch(branch);
        accountService.save(account);
    }

    public Account readAccount(Long id) {
        return accountService.findById(id);
    }

    public void updateAccount(Long id, AccountRequestDto requestDto) {
        Account account = modelMapper.map(requestDto, Account.class);
        account.setId(id);
        accountService.update(account);
    }

    public void deleteAccount(Long id) {
        accountService.delete(id);
    }
}
