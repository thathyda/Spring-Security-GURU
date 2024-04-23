package com.cstad.itebankingprojectdemo.features.cardtype;

import com.cstad.itebankingprojectdemo.features.cardtype.dto.CardTypeResponse;

import java.util.List;

public interface CardTypeService {
    List<CardTypeResponse> findAllCardType();
    CardTypeResponse findCardTypeByName(String name);
}