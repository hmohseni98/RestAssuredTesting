package com.banking.dummybankingapi.service.dto;

import com.banking.dummybankingapi.model.Account;
import com.banking.dummybankingapi.service.dto.base.BaseRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto extends BaseRequestDto {
    private Long id;
    private BigDecimal amount;
    private Integer type;
    private String accountCodeFrom;
    private String accountCodeTo;
    private String comment;

}
