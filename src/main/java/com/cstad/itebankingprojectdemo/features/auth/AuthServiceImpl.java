package com.cstad.itebankingprojectdemo.features.auth;

import com.cstad.itebankingprojectdemo.base.BasedMessage;
import com.cstad.itebankingprojectdemo.domain.User;
import com.cstad.itebankingprojectdemo.features.auth.dto.AuthResponse;
import com.cstad.itebankingprojectdemo.features.auth.dto.ChangePasswordRequest;
import com.cstad.itebankingprojectdemo.features.auth.dto.LoginRequest;
import com.cstad.itebankingprojectdemo.features.auth.dto.RefreshTokenRequest;
import com.cstad.itebankingprojectdemo.features.token.TokenService;
import com.cstad.itebankingprojectdemo.features.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService{
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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

    @Override
    public BasedMessage changePassword(Jwt jwt, ChangePasswordRequest request) {
        User user = userRepository.findByPhoneNumber(jwt.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found")
                );
        if (!passwordEncoder.matches(request.oldPassword(),user.getPassword())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Old password incorrect..!"
            );
        }
        if (!request.newPassword().equals(request.confirmedPassword())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"New Password and Confirm password isn't the same please try again..!"
            );
        }
        user.setPassword(passwordEncoder.encode(request.newPassword()));
        userRepository.save(user);
        return new BasedMessage("Your Password has been changed successfully....!!");
    }
}
