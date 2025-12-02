package com.example.ITPMongoDB.service.Impl;

import com.example.ITPMongoDB.domain.User;
import com.example.ITPMongoDB.dto.FilterDto;
import com.example.ITPMongoDB.dto.UserRequest;
import com.example.ITPMongoDB.dto.UserResponse;
import com.example.ITPMongoDB.filter.FilteringFactory;
import com.example.ITPMongoDB.mapper.UserMapper;
import com.example.ITPMongoDB.repository.UserRepository;
import com.example.ITPMongoDB.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<UserResponse> filterUsers(FilterDto filterDto, int page, int size) {

        Sort sortByName = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(page, size, sortByName);

        Page<User>filteredUsers = userRepository.findAllWithFilter(User.class,
                FilteringFactory.parseFromParams(filterDto.filter(),User.class),pageable
                );

        return filteredUsers.map(userMapper::toUserResponse);
    }


    @Override
    public Page<UserResponse> findAll(int page, int size) {

        Sort sortByName = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(page, size, sortByName);

        Page<User> users = userRepository.findAll(pageable);

        return users.map(userMapper::toUserResponse);
    }

    @Override
    public UserResponse findById(String id) {

        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, " User with id " + id + " not found."
                )
        );
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.fromUserRequest(userRequest);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUserById(String id, UserRequest userRequest) {

        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, " User with id " + id + " not found."
                )
        );

        userMapper.fromUserUpdateRequestPartially(userRequest, user);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUserById(String id) {

        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, " User with id " + id + " not found."
                )
        );
        userRepository.delete(user);

    }
}
