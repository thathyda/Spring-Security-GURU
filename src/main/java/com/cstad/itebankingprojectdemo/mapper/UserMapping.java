package com.cstad.itebankingprojectdemo.mapper;

import com.cstad.itebankingprojectdemo.domain.User;
import com.cstad.itebankingprojectdemo.domain.UserAccount;
import com.cstad.itebankingprojectdemo.features.user.dto.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapping {
    User fromUserCreateRequest (UserCreateRequest request);

//    UserDetailResponse toUserDetailsResponse(User user);

    User fromUserEditProfileRequest(UserEditProfileRequest request);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUserUpadateRequest(UserUpadateRequest request, @MappingTarget User user);

    UserDetailResponse toUserResponse(User user);
    UserResponse toUserRes(User user);

//    List<UserResponse> toUserResponeList(List<User> findAll);

    UserResponse toUserResponseList(User user);
    @Named("mapUserResponse")
    default UserResponse mapUserResponse(List<UserAccount> userAccountList){
        return toUserRes(userAccountList.get(0).getUser());
    }



}