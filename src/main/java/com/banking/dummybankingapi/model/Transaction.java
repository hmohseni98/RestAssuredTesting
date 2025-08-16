package com.banking.dummybankingapi.model;


import com.banking.dummybankingapi.model.base.BaseEntity;
import com.banking.dummybankingapi.model.enumeration.TransactionStatusTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Transaction extends BaseEntity<Long> {

    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    private LocalDateTime date;

    private Integer type;

    private String accountCodeFrom;

    private String accountCodeTo;

    private String comment;

    @Enumerated(EnumType.STRING)
    private TransactionStatusTypeEnum status;


    public Transaction(Long id, BigDecimal amount, Integer type, String accountCodeFrom, String accountCodeTo, String comment) {
        super(id);
        this.amount = amount;
        this.type = type;
        this.accountCodeFrom = accountCodeFrom;
        this.accountCodeTo = accountCodeTo;
        this.comment = comment;
    }

    @PrePersist
    public void prePersist() {
        if (date == null) {
            date = LocalDateTime.now();
        }

        if (status == null) {
            status = TransactionStatusTypeEnum.PENDING;
        }
    }

}
