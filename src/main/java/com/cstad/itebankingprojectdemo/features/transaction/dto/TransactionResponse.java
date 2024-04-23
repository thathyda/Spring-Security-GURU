package com.cstad.itebankingprojectdemo.features.transaction.dto;

import com.cstad.itebankingprojectdemo.features.account.dto.AccountSnippetResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        AccountSnippetResponse owner,
        AccountSnippetResponse transferReceiver,
        BigDecimal amount,
        String remark,
        String transactionType,
        Boolean status,
        LocalDateTime transactionAt
) {
}