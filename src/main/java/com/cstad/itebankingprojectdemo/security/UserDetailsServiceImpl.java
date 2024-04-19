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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserService {
   private UserRepository userRepository;
   private UserService userService;

    @Override
    public void createNew(UserCreateRequest userCreateRequest) {

    }

    @Override
    public UserResponse updateByUuid(String uuid, UserUpdateRequest userUpdateRequest) {
        return null;
    }

    @Override
    public Page<UserResponse> findList(int page, int limit) {
        return null;
    }

    @Override
    public UserDetailsResponse findByUuid(String uuid) {
        return null;
    }

    @Override
    public BasedMessage blockByUuid(String uuid) {
        return null;
    }
    @Override
    public void deleteByUuid(String uuid) {

    }
}
