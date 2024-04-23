package com.cstad.itebankingprojectdemo.features.account;

import com.cstad.itebankingprojectdemo.features.account.dto.AccountCreateRequest;
import com.cstad.itebankingprojectdemo.features.account.dto.AccountLimitTransRequest;
import com.cstad.itebankingprojectdemo.features.account.dto.AccountRenameRequest;
import com.cstad.itebankingprojectdemo.features.account.dto.AccountResponse;
import org.springframework.data.domain.Page;

public interface AccountService {
    void createNew(AccountCreateRequest request);
    AccountResponse findAccByActNo(String actNo);
    AccountResponse renameByActNo(String actNo, AccountRenameRequest request);
    void hideAccount(String actNo);

    Page<AccountResponse> findList(int page, int size);

    void updateLimitTransByActNo(String actNo, AccountLimitTransRequest request);
}