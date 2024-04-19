package com.cstad.itebankingprojectdemo.features.accounttype;

import com.cstad.itebankingprojectdemo.domain.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

    <AccountType> Optional<AccountType> findByAlias(String alias);

}
