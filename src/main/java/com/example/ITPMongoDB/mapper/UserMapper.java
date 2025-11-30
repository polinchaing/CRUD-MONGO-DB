package com.example.ITPMongoDB.mapper;

import com.example.ITPMongoDB.domain.User;
import com.example.ITPMongoDB.dto.UserRequest;
import com.example.ITPMongoDB.dto.UserResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Convert User entity -> UserResponse DTO
    UserResponse toUserResponse(User user);

    // Convert UserRequest DTO -> User entity
    User fromUserRequest(UserRequest userRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUserUpdateRequestPartially(UserRequest userRequest, @MappingTarget User user);

}
