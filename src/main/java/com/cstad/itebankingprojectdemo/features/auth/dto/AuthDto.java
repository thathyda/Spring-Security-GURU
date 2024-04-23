package com.cstad.itebankingprojectdemo.features.auth.dto;

public record AuthDto(
        String type,
        String accessToken,
        String refreshToken
) {
}
