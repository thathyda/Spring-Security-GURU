package com.cstad.itebankingprojectdemo.mapper;

import com.cstad.itebankingprojectdemo.domain.User;
import com.cstad.itebankingprojectdemo.features.user.dto.UserCreateRequest;
import com.cstad.itebankingprojectdemo.features.user.dto.UserDetailsResponse;
import com.cstad.itebankingprojectdemo.features.user.dto.UserResponse;
import com.cstad.itebankingprojectdemo.features.user.dto.UserUpdateRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // SourceType = UserCreateRequest (Parameter)
    // TargetType = User (ReturnType)
    User fromUserCreateRequest(UserCreateRequest userCreateRequest);

    void fromUserCreateRequest2(@MappingTarget User user, UserCreateRequest userCreateRequest);

    UserDetailsResponse toUserDetailsResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUserUpdateRequest(UserUpdateRequest userUpdateRequest, @MappingTarget User user);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponseList(List<User> users);
}
