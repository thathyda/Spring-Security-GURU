package com.cstad.itebankingprojectdemo.mapper;

import com.cstad.itebankingprojectdemo.domain.Transaction;
import com.cstad.itebankingprojectdemo.features.transaction.dto.TransactionCreateRequest;
import com.cstad.itebankingprojectdemo.features.transaction.dto.TransactionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = AccountMapper.class)
public interface TransactionMapper {
    TransactionResponse toTransactionResponse (Transaction transaction);
    Transaction fromTransactionCreateRequest(TransactionCreateRequest request);
}