package com.cstad.itebankingprojectdemo.features.transaction;

import com.cstad.itebankingprojectdemo.domain.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    Page<Transaction> findByTransactionType(String transactionType, PageRequest pageRequest);
}