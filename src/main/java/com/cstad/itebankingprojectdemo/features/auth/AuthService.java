package com.cstad.itebankingprojectdemo.features.auth;


import com.cstad.itebankingprojectdemo.features.auth.dto.AuthResponse;
import com.cstad.itebankingprojectdemo.features.auth.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;

public interface AuthService {
    AuthResponse login(LoginRequest request);
}