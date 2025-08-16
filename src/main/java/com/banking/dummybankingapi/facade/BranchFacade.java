package com.banking.dummybankingapi.facade;

import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.model.Branch;
import com.banking.dummybankingapi.service.BranchService;
import com.banking.dummybankingapi.service.dto.BranchRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BranchFacade {
    private final BranchService branchService;
    private final ModelMapper modelMapper;

    public List<Branch> listAllBranches() {
        return branchService.findAll();
    }

    public void createBranch(BranchRequestDto requestDto) {
        Branch branch = modelMapper.map(requestDto, Branch.class);
        branchService.save(branch);
    }

    public Branch readBranch(Long id) {
        return branchService.findById(id);
    }

    public void updateBranch(Long id, BranchRequestDto requestDto) {
        Branch branch = modelMapper.map(requestDto, Branch.class);
        branch.setId(id);
        branchService.update(branch);
    }

    public void deleteBranch(Long id) {
        branchService.delete(id);
    }
}
