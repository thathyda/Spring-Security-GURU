package com.cstad.itebankingprojectdemo.mapper;

import com.cstad.itebankingprojectdemo.domain.Account;
import com.cstad.itebankingprojectdemo.features.account.dto.AccountCreateRequest;
import com.cstad.itebankingprojectdemo.features.account.dto.AccountResponse;
import com.cstad.itebankingprojectdemo.features.account.dto.AccountSnippetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapping.class)
//@Mapper(componentModel = "spring", uses = {
//      UserMapping.class
//      AccountTypeMapper.class
// })
public interface AccountMapper {
    Account fromAccountCreateRequest(AccountCreateRequest request);
    @Mapping(source = "userAccountList",target = "user",qualifiedByName = "mapUserResponse")
    AccountResponse toAccountResponse(Account account);
    AccountSnippetResponse toAccountSnippetResponse (Account account);
}
