package com.cstad.itebankingprojectdemo.features.transaction;

import com.cstad.itebankingprojectdemo.features.transaction.dto.TransactionCreateRequest;
import com.cstad.itebankingprojectdemo.features.transaction.dto.TransactionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

public interface TransactionService {
    TransactionResponse transfers (TransactionCreateRequest request);
    Page<TransactionResponse> transactionHistory (int page, int size,String sortDirection,String transactionType);
}