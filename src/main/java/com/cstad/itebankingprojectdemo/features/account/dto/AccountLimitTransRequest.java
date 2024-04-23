package com.cstad.itebankingprojectdemo.features.account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record AccountLimitTransRequest(
        @Positive
        @NotNull
        BigDecimal transferLimit
) {
}