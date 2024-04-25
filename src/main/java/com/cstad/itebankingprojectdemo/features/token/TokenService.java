package com.cstad.itebankingprojectdemo.features.token;

import com.cstad.itebankingprojectdemo.features.auth.dto.AuthResponse;
import org.springframework.security.core.Authentication;

public interface TokenService {
        AuthResponse createToken(Authentication auth);
        String accessToken(Authentication auth);
        String refreshToken(Authentication auth);
    }


