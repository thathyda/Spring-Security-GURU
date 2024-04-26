package com.cstad.itebankingprojectdemo.features.auth;


import com.cstad.itebankingprojectdemo.base.BasedMessage;
import com.cstad.itebankingprojectdemo.features.auth.dto.AuthResponse;
import com.cstad.itebankingprojectdemo.features.auth.dto.ChangePasswordRequest;
import com.cstad.itebankingprojectdemo.features.auth.dto.LoginRequest;
import com.cstad.itebankingprojectdemo.features.auth.dto.RefreshTokenRequest;
import com.nimbusds.jwt.JWT;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.jwt.Jwt;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse refresh(RefreshTokenRequest request);

    BasedMessage changePassword (Jwt jwt , ChangePasswordRequest request);
}