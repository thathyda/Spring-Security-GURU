package com.cstad.itebankingprojectdemo.features.transaction;

import com.cstad.itebankingprojectdemo.domain.Account;
import com.cstad.itebankingprojectdemo.domain.Transaction;
import com.cstad.itebankingprojectdemo.features.account.AccountRepository;
import com.cstad.itebankingprojectdemo.features.accounttype.AccountTypeRepository;
import com.cstad.itebankingprojectdemo.features.transaction.dto.TransactionCreateRequest;
import com.cstad.itebankingprojectdemo.features.transaction.dto.TransactionResponse;
import com.cstad.itebankingprojectdemo.mapper.TransactionMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final TransactionMapper transactionMapper;
    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public TransactionResponse transfers(TransactionCreateRequest request) {
        log.info("transfers(TransactionCreateRequest request) :{}", request);
        // validation owner account number and receiver account number
        Account owner = accountRepository.findByActNo(request.ownerActNo())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Not Found Owner!!"
                        ));
        Account receiver = accountRepository.findByActNo(request.transferReceiverActNo())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Not Found Receiver!!"
                        ));
        // check amount transfer
        if (owner.getActNo().equals(receiver.getActNo())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "You can't transfer to your own account"
            );
        }
        if (owner.getBalance().doubleValue() < request.amount().doubleValue()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "INSUFFICIENT BALANCE"
            );
        }
        // check amount transfer
        if (owner.getTransferLimit().doubleValue() < request.amount().doubleValue()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "TRANSACTION TRANSFER HAS BEEN OVER LIMIT!!"
            );
        }
        // withdraw from owner
        owner.setBalance(owner.getBalance().subtract(request.amount()));
        // deposit to receiver
        receiver.setBalance(receiver.getBalance().add(request.amount()));
        Transaction transaction = transactionMapper.fromTransactionCreateRequest(request);
        transaction.setOwner(owner);
        transaction.setTransferReceiver(receiver);
        transaction.setTransactionType("Transfer");
        transaction.setTransactionAt(LocalDateTime.now());
        transaction.setStatus(true);
        transaction = transactionRepository.save(transaction);

        return transactionMapper.toTransactionResponse(transaction);
    }

    @Override
    public Page<TransactionResponse> transactionHistory(int page, int size, String sort, String transactionType) {
        if (page < 0 || size < 1) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Page can't be less than 0 or Size can't be less than 1 please check the URI again!!"
            );
        }
        Sort.Direction direction = sort.equalsIgnoreCase("date:asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortByTransactionAt = Sort.by(direction, "transactionAt");

        PageRequest pageRequest = PageRequest.of(page, size, sortByTransactionAt);

        Page<Transaction> transactions;
        if (transactionType != null && !transactionType.isEmpty()) {
            transactions = transactionRepository.findByTransactionType(transactionType, pageRequest);
        } else {
            transactions = transactionRepository.findAll(pageRequest);
        }
        return transactions.map(transactionMapper::toTransactionResponse);
    }
}