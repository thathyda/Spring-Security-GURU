package com.cstad.itebankingprojectdemo.features.cardtype;

import com.cstad.itebankingprojectdemo.domain.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardTypeRepository extends JpaRepository<CardType, Long> {

    CardType findByNameIgnoreCase(String name);
}
