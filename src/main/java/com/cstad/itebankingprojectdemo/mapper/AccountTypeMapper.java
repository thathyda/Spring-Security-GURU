package com.cstad.itebankingprojectdemo.mapper;

import com.cstad.itebankingprojectdemo.domain.AccountType;
import com.cstad.itebankingprojectdemo.features.accounttype.dto.AccountTypeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountTypeMapper {

    AccountTypeResponse toAccountTypeResponse(AccountType accountType);

    List<AccountTypeResponse> toAccountTypeResponseList(List<AccountType> accountTypes);

}
