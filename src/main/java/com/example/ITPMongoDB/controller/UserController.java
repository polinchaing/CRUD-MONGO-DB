package com.example.ITPMongoDB.controller;

import com.example.ITPMongoDB.dto.UserRequest;
import com.example.ITPMongoDB.dto.UserResponse;
import com.example.ITPMongoDB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<UserResponse> findAll(
            @RequestParam(required = false, defaultValue = "0")int page,
            @RequestParam(required = false, defaultValue = "25")int size
    ) {
        return userService.findAll(page,size);
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UserResponse updateUserById(@PathVariable String id, @RequestBody UserRequest userRequest) {
        return userService.updateUserById(id, userRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
    }

}
