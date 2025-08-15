package com.banking.dummybankingapi.model;


import com.banking.dummybankingapi.model.enumerated.TransactionStatusTypeEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long amount;

    @CreationTimestamp
    private LocalDateTime date;

    private Integer type;

    private String accountCodeFrom;

    private String accountCodeTo;

    private String comment;

    @Enumerated(EnumType.STRING)
    private TransactionStatusTypeEnum status = TransactionStatusTypeEnum.PENDING;


}
