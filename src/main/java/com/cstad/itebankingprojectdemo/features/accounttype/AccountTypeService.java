package com.cstad.itebankingprojectdemo.features.accounttype;

import com.cstad.itebankingprojectdemo.features.accounttype.dto.AccountTypeResponse;

import java.util.List;

public interface AccountTypeService {

    List<AccountTypeResponse> findList();

    AccountTypeResponse findByAlias(String alias);

}
