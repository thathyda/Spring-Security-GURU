package com.cstad.itebankingprojectdemo.features.account.dto;

import com.cstad.itebankingprojectdemo.features.accounttype.dto.AccountTypeResponse;
import com.cstad.itebankingprojectdemo.features.user.dto.UserResponse;

public record AccountResponse(
        String actNo,
        String actName,
        String alias,
        String balance,
        AccountTypeResponse accountType,
        UserResponse user
) {
}