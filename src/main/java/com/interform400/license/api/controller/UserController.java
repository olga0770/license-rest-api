package com.interform400.license.api.controller;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import com.interform400.license.api.repository.PartnerRepository;
import com.interform400.license.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    private final PartnerRepository partnerRepository;

    @Autowired
    public UserController(UserRepository userRepository, PartnerRepository partnerRepository) {
        this.userRepository = userRepository;
        this.partnerRepository = partnerRepository;
    }


    @PostMapping("/create")
    @ResponseBody
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.getUserName());
        Optional<Partner> partner = partnerRepository.findById(createUserRequest.getPartnerId());
        if (partner.isPresent()) {
            user.setPartner(partner.get());
            return userRepository.save(user);
        }
        else {
            throw new NotFoundException("partner", createUserRequest.getPartnerId().toString());
        }
    }

    @DeleteMapping("/extra/{id}") // does the same as DELETE(/id)
    public void deleteUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
    }

}
