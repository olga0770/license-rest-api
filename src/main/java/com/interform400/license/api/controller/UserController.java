package com.interform400.license.api.controller;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import com.interform400.license.api.repository.PartnerRepository;
import com.interform400.license.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@SuppressWarnings("squid:S3457")
public class UserController {

    private final UserRepository userRepository;

    private final PartnerRepository partnerRepository;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserRepository userRepository, PartnerRepository partnerRepository) {
        this.userRepository = userRepository;
        this.partnerRepository = partnerRepository;
    }


    @GetMapping
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        for (User user : iterable) {
            setPartnerOnUser(user, getPartnerOfUser(user), true);
            result.add(user);
        }
        return result;
    }

    private Optional<Partner> getPartnerOfUser(User user) {
        return partnerRepository.findById(user.getPartner().getId());
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            setPartnerOnUser(user, getPartnerOfUser(user), true);
            return user;
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
    }

    private void setPartnerOnUser(User user, Optional<Partner> optionalPartner, boolean fromDatabase) {
        if (optionalPartner.isPresent()) {
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
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
    }


    @PatchMapping("/{id}")
    @ResponseBody
    public User updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(updateUserRequest.getUsername());
            Optional<Partner> optionalPartner = partnerRepository.findById(updateUserRequest.getPartnerId());
            setPartnerOnUser(user, optionalPartner, false);
            return userRepository.save(user);
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
    }


}
