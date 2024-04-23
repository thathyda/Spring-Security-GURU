package com.cstad.itebankingprojectdemo.features.auth;

import com.cstad.itebankingprojectdemo.features.auth.dto.AuthResponse;
import com.cstad.itebankingprojectdemo.features.auth.dto.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Service
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    AuthResponse authResponse(@Valid @RequestBody LoginRequest request){
        return authService.login(request);
    }
}