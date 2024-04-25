package com.cstad.itebankingprojectdemo.features.user;

import com.cstad.itebankingprojectdemo.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
