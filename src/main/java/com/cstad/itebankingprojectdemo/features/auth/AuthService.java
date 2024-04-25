package com.cstad.itebankingprojectdemo.features.auth;


import com.cstad.itebankingprojectdemo.features.auth.dto.AuthResponse;
import com.cstad.itebankingprojectdemo.features.auth.dto.LoginRequest;
import com.cstad.itebankingprojectdemo.features.auth.dto.RefreshTokenRequest;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse refresh(RefreshTokenRequest request);
}