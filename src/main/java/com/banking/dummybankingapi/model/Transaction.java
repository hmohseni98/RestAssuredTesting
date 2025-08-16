package com.banking.dummybankingapi.model;


import com.banking.dummybankingapi.model.base.BaseEntity;
import com.banking.dummybankingapi.model.enumeration.TransactionStatusTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Transaction extends BaseEntity<Long> {
    private Long amount;

    @CreationTimestamp
    private LocalDateTime date;

    private Integer type;

    @ManyToOne
    private Account accountFrom;

    @ManyToOne
    private Account accountTo;

    private String comment;

    @Enumerated(EnumType.STRING)
    private TransactionStatusTypeEnum status;


    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = TransactionStatusTypeEnum.PENDING;
        }
    }
}
