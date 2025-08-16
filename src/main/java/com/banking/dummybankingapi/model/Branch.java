package com.banking.dummybankingapi.model;

import com.banking.dummybankingapi.model.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Branch extends BaseEntity<Long> {
    private Integer code;

    private String description;
}
