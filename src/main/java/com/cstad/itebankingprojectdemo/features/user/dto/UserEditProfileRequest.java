package com.cstad.itebankingprojectdemo.features.user.dto;


import java.math.BigDecimal;

public record UserEditProfileRequest(
        String phoneNumber,
        String cityOrProvince,
        String khanOrDistrict,
        String sangkatOrCommune,
        String employeeType,
        String position,
        String companyName,
        String mainSourceOfIncome,
        BigDecimal monthlyIncomeRange
) {
}