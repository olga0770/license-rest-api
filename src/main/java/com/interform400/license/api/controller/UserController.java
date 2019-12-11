package com.interform400.license.api.controller;

import com.interform400.license.api.controller.request.CreateUserRequest;
import com.interform400.license.api.controller.request.UpdateUserRequest;
import com.interform400.license.api.controller.response.UserDataResponse;
import com.interform400.license.api.service.data.UserData;
import com.interform400.license.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The User REST controller.
 * Responsible for receiving requests from external HTTP clients, and deliver a response.
 */
@RestController
@RequestMapping("/users")
@SuppressWarnings("squid:S3457")
public class UserController {

    private final UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    @ResponseBody
    public List<UserDataResponse> getAllUsers() {
        logger.info("getAllUsers()");
        return convertToResponse(userService.getUsers());
    }

    private List<UserDataResponse> convertToResponse(List<UserData> users) {
        List<UserDataResponse> result = new ArrayList<>();
        for (UserData userData: users) {
            result.add(new UserDataResponse(userData));
        }

        logger.info("convertToResponse():" + result);

        return result;
    }


    @GetMapping("/{id}")
    public UserDataResponse getUser(@PathVariable Long id) {
        final UserDataResponse result = new UserDataResponse(userService.getUser(id));

        logger.info("getUser():" + result);

        return result;
    }


    @PostMapping
    @ResponseBody
    public UserDataResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        logger.info("calling createUser:" + createUserRequest.getUsername() + ":" + createUserRequest.getPartnerId());

        return new UserDataResponse(userService.createUser(createUserRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    @PatchMapping("/{id}")
    @ResponseBody
    public UserDataResponse updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        return new UserDataResponse(userService.updateUser(id, updateUserRequest));
    }


}