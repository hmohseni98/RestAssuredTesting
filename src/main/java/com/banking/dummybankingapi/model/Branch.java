package com.banking.dummybankingapi.model;

import com.banking.dummybankingapi.model.base.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Branch extends BaseEntity<Long> {
    private Integer code;

    private String description;
}
