package com.cstad.itebankingprojectdemo.features.auth;

import com.cstad.itebankingprojectdemo.features.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;


    @Override
    public Boolean authenticate(String email, String password) {
        log.info("Authenticating " + email);
        return null;
    }
}
