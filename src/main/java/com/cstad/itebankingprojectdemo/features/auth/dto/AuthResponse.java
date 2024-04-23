package com.cstad.itebankingprojectdemo.features.auth.dto;

public record AuthResponse(
        String type,
        String accessToken,
        String refreshToken

) {
}
