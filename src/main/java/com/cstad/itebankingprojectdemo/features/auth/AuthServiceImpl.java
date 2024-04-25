package com.cstad.itebankingprojectdemo.features.auth;

import com.cstad.itebankingprojectdemo.features.auth.dto.AuthResponse;
import com.cstad.itebankingprojectdemo.features.auth.dto.LoginRequest;
import com.cstad.itebankingprojectdemo.features.auth.dto.RefreshTokenRequest;
import com.cstad.itebankingprojectdemo.features.token.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService{
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final TokenService tokenService;

    @Override
    public AuthResponse login(LoginRequest request) {
        // Auth with DTO
        Authentication auth  = new UsernamePasswordAuthenticationToken(
                request.phoneNumber(),
                request.password()
        );
        auth = daoAuthenticationProvider.authenticate(auth);
        return tokenService.createToken(auth);
    }

    @Override
    public AuthResponse refresh(RefreshTokenRequest request) {
        Authentication auth  = new BearerTokenAuthenticationToken(
                request.refreshToken()
        );
        auth = jwtAuthenticationProvider.authenticate(auth);

        return tokenService.createToken(auth);

    }
}
