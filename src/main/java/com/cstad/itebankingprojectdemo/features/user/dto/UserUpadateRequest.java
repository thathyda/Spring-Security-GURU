package com.cstad.itebankingprojectdemo.features.user.dto;

import java.time.LocalDate;

public record UserUpadateRequest(
        String name,
        String gender,
        LocalDate dob,
        String studentIdCard
) {
}