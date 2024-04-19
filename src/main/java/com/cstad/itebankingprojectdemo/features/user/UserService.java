package com.cstad.itebankingprojectdemo.features.user;

import com.cstad.itebankingprojectdemo.base.BasedMessage;
import com.cstad.itebankingprojectdemo.features.user.dto.UserCreateRequest;
import com.cstad.itebankingprojectdemo.features.user.dto.UserDetailsResponse;
import com.cstad.itebankingprojectdemo.features.user.dto.UserResponse;
import com.cstad.itebankingprojectdemo.features.user.dto.UserUpdateRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void createNew(UserCreateRequest userCreateRequest);

    UserResponse updateByUuid(String uuid, UserUpdateRequest userUpdateRequest);

    Page<UserResponse> findList(int page, int limit);

    UserDetailsResponse findByUuid(String uuid);

    BasedMessage blockByUuid(String uuid);

    void deleteByUuid(String uuid);
}
