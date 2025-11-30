package com.example.ITPMongoDB.service;

import com.example.ITPMongoDB.domain.User;
import com.example.ITPMongoDB.dto.UserRequest;
import com.example.ITPMongoDB.dto.UserResponse;

import java.util.List;

public interface UserService {

    // Find All User
    List<UserResponse> findAll();

    // Find UserById
    UserResponse findById(String id);

    // Create New User
    UserResponse createUser(UserRequest userRequest);

    // Update User By ID
    UserResponse updateUserById(String id, UserRequest userRequest);

    // Deleted User By ID
    void deleteUserById(String id);


}
