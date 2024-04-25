package com.cstad.itebankingprojectdemo.features.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record RefreshTokenRequest(
        @NotBlank(message = "Refresh Token is required")
        String refreshToken
) {
}