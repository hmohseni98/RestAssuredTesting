package com.banking.dummybankingapi.service.dto;

import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.service.dto.base.BaseRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto extends BaseRequestDto {
    private Long amount;

    private Integer type;

    private Long accountIdFrom;

    private Long accountIdTo;

    private String comment;

    private String status;
}
