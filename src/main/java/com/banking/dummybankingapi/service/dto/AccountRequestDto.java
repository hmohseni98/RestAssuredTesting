package com.banking.dummybankingapi.service.dto;

import com.banking.dummybankingapi.service.dto.base.BaseRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto extends BaseRequestDto {
    private String code;
    private String name;
    private Integer branchCode;
}
