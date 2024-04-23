package com.cstad.itebankingprojectdemo.features.account;

import com.cstad.itebankingprojectdemo.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
}