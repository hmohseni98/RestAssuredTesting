package com.banking.dummybankingapi.model;

import com.banking.dummybankingapi.model.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Account extends BaseEntity<Long> {
    private String code;
    private String name;

    public Account(Long id, String code, String name) {
        super(id);
        this.code = code;
        this.name = name;
    }
}
