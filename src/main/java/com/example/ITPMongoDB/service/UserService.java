package com.example.ITPMongoDB.service;
import com.example.ITPMongoDB.dto.FilterDto;
import com.example.ITPMongoDB.dto.UserRequest;
import com.example.ITPMongoDB.dto.UserResponse;
import org.springframework.data.domain.Page;


public interface UserService {

    // Advanced Filtering
    Page<UserResponse>filterUsers(FilterDto filterDto,int page,int size);

    // Find All User
    Page<UserResponse> findAll(int page, int size);

    // Find UserById
    UserResponse findById(String id);

    // Create New User
    UserResponse createUser(UserRequest userRequest);

    // Update User By ID
    UserResponse updateUserById(String id, UserRequest userRequest);

    // Deleted User By ID
    void deleteUserById(String id);


}
