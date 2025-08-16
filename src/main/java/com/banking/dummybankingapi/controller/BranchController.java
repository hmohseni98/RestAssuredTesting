package com.banking.dummybankingapi.controller;

import com.banking.dummybankingapi.facade.BranchFacade;
import com.banking.dummybankingapi.model.Branch;
import com.banking.dummybankingapi.service.dto.BranchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/branches/")
@RequiredArgsConstructor
public class BranchController {

    private final BranchFacade branchFacade;

    @GetMapping
    public List<Branch> listAllBranches() {
        return branchFacade.listAllBranches();
    }

    @PostMapping
    public ResponseEntity<Void> createBranch(@RequestBody BranchRequestDto requestDto) {
        branchFacade.createBranch(requestDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Branch> readBranch(@PathVariable Long id) {
        return ResponseEntity.ok(branchFacade.readBranch(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateBranch(@PathVariable Long id, @RequestBody BranchRequestDto requestDto) {
        branchFacade.updateBranch(id, requestDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchFacade.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
