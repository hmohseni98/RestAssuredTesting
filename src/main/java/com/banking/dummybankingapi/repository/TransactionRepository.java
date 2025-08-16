package com.banking.dummybankingapi.repository;

import com.banking.dummybankingapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Modifying
    @Query(value = " update Transaction set comment = :comment where id = :id" )
    void updateCommentById(@Param("id") Long id, @Param("comment") String comment);
}
