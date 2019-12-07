package com.interform400.license.api.service;

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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void deleteUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
    }


    public UserData getUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            setPartnerOnUser(user, getPartnerOfUser(user), true);
            return new UserData(user);
        }
        else {
            throw new NotFoundException("user", id.toString());
        }
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


}
