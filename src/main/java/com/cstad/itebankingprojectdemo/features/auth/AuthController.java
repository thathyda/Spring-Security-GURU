package com.cstad.itebankingprojectdemo.features.auth;

import com.cstad.itebankingprojectdemo.base.BasedMessage;
import com.cstad.itebankingprojectdemo.features.auth.dto.AuthResponse;
import com.cstad.itebankingprojectdemo.features.auth.dto.ChangePasswordRequest;
import com.cstad.itebankingprojectdemo.features.auth.dto.LoginRequest;
import com.cstad.itebankingprojectdemo.features.auth.dto.RefreshTokenRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    AuthResponse authResponse(@Valid @RequestBody LoginRequest request){
        return authService.login(request);
    }

    @PostMapping("/refresh")
    AuthResponse refresh(@Valid @RequestBody RefreshTokenRequest request){
        return authService.refresh(request);
    }

    @PutMapping("/change-pwd")
    BasedMessage changePassword(@Valid @RequestBody ChangePasswordRequest request,
                                @AuthenticationPrincipal Jwt jwt){
        return authService.changePassword(jwt,request);
    }
}