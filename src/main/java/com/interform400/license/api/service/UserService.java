package com.interform400.license.api.service;

import com.interform400.license.api.controller.request.CreateUserRequest;
import com.interform400.license.api.controller.request.UpdateUserRequest;
import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import com.interform400.license.api.exception.NotFoundException;
import com.interform400.license.api.exception.ServerSideException;
import com.interform400.license.api.repository.PartnerRepository;
import com.interform400.license.api.repository.UserRepository;
import com.interform400.license.api.service.data.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The User service class.
 * Responsible for encapsulating the user data and make it available for different clients,
 * e.g. REST controllers, HTML controllers, XML web services, etc.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PartnerRepository partnerRepository;


    Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<UserData> getUsers() {
        logger.info("getUsers()");

        List<User> users = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        for (User user : iterable) {
            setPartnerOnUser(user, getPartnerOfUser(user), true);
            users.add(user);
        }
        return convertToData(users);
    }

    private List<UserData> convertToData(List<User> users) {
        logger.info("convertToData()");

        List<UserData> result = new ArrayList<>();

        for (User user: users) {
            result.add(new UserData(user));
        }

        logger.info("convertToData():result:" + result);

        return result;
    }

    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
    }


    @NotNull
    public UserData getUser(Long id) {
        final UserData result;
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            setPartnerOnUser(user, getPartnerOfUser(user), true);
            result = new UserData(user);
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
        logger.info("getUser():result: " + result);
        return result;
    }


    private Optional<Partner> getPartnerOfUser(User user) {
        return partnerRepository.findById(user.getPartner().getId());
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


    public UserData createUser(CreateUserRequest createUserRequest) {
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
            return new UserData(userRepository.save(user));
        }
        else {
            throw new NotFoundException("partner", createUserRequest.getPartnerId().toString());
        }
    }


    public UserData updateUser(Long id, UpdateUserRequest updateUserRequest) {
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
            return new UserData(userRepository.save(user));
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
    }

}
