package com.cstad.itebankingprojectdemo.security;

import com.cstad.itebankingprojectdemo.base.BasedMessage;
import com.cstad.itebankingprojectdemo.domain.User;
import com.cstad.itebankingprojectdemo.features.user.UserRepository;
import com.cstad.itebankingprojectdemo.features.user.UserService;
import com.cstad.itebankingprojectdemo.features.user.dto.UserCreateRequest;
import com.cstad.itebankingprojectdemo.features.user.dto.UserDetailsResponse;
import com.cstad.itebankingprojectdemo.features.user.dto.UserResponse;
import com.cstad.itebankingprojectdemo.features.user.dto.UserUpdateRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@ToString
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneNumber(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User has not been found with username: " + username));
        log.info("User: {}",user);

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);
        return customUserDetails;
    }
}