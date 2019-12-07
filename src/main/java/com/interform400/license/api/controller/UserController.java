package com.interform400.license.api.controller;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import com.interform400.license.api.exception.NotFoundException;
import com.interform400.license.api.exception.ServerSideException;
import com.interform400.license.api.repository.PartnerRepository;
import com.interform400.license.api.repository.UserRepository;
import com.interform400.license.api.service.data.UserData;
import com.interform400.license.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/users")
@SuppressWarnings("squid:S3457")
public class UserController {

    private final UserRepository userRepository;
    private final PartnerRepository partnerRepository;

    private final UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserRepository userRepository, PartnerRepository partnerRepository, UserService userService) {
        this.userRepository = userRepository;
        this.partnerRepository = partnerRepository;
        this.userService = userService;
    }


    @GetMapping
    @ResponseBody
    public List<UserData> getAllUsers() {
        logger.info("getAllUsers()");
        return userService.getUsers();
    }


    @GetMapping("/{id}")
    public UserData getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    private void setPartnerOnUser(User user, Optional<Partner> optionalPartner, boolean fromDatabase) {
        if (optionalPartner.isPresent()) {
            Partner partner = optionalPartner.get();
            partner.setUsers(null); // to avoid infinite recursion
            user.setPartner(optionalPartner.get());
        }
        else {
            if (fromDatabase) {
                throw new ServerSideException("Corrupt Data - no partner for user id:" + user.getId());
            }
            else {
                throw new NotFoundException("partner", null);
            }
        }
    }


    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {
        logger.info("calling createUser:" + createUserRequest.getUsername() + ":" + createUserRequest.getPartnerId());

        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(createUserRequest.getPassword());
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setEmail(createUserRequest.getEmail());
        user.setPhone(createUserRequest.getPhone());
        user.setAddress(createUserRequest.getAddress());
        user.setZip(createUserRequest.getZip());
        user.setCity(createUserRequest.getCity());
        user.setCountry(createUserRequest.getCountry());
        user.setRole(createUserRequest.getRole());

        Optional<Partner> partner = partnerRepository.findById(createUserRequest.getPartnerId());
        if (partner.isPresent()) {
            user.setPartner(partner.get());
            return userRepository.save(user);
        }
        else {
            throw new NotFoundException("partner", createUserRequest.getPartnerId().toString());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    @PatchMapping("/{id}")
    @ResponseBody
    public User updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(updateUserRequest.getUsername());
            user.setPassword(updateUserRequest.getPassword());
            user.setFirstName(updateUserRequest.getFirstName());
            user.setLastName(updateUserRequest.getLastName());
            user.setEmail(updateUserRequest.getEmail());
            user.setPhone(updateUserRequest.getPhone());
            user.setAddress(updateUserRequest.getAddress());
            user.setZip(updateUserRequest.getZip());
            user.setCity(updateUserRequest.getCity());
            user.setCountry(updateUserRequest.getCountry());

            Optional<Partner> optionalPartner = partnerRepository.findById(updateUserRequest.getPartnerId());
            setPartnerOnUser(user, optionalPartner, false);
            return userRepository.save(user);
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
    }


}