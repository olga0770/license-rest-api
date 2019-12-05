package com.interform400.license.api.controller;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.exception.NotFoundException;
import com.interform400.license.api.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// @CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerRepository partnerRepository;
    // private final UserRepository userRepository;

    @Autowired
    public PartnerController(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
        // this.userRepository = userRepository;
    }
    // UserRepository userRepository



//    @GetMapping
//    @ResponseBody
//    public List<Partner> getAllPartners() {
//        List<Partner> result = new ArrayList<>();
//        Iterable<Partner> iterable = partnerRepository.findAll();
//        for (Partner partner : iterable) {
//            setUsersOnPartner(partner, getUsersOfPartner(partner), true);
//            result.add(partner);
//        }
//        return result;
//    }
//    private List<User> getUsersOfPartner(Partner partner) {
//        return userRepository.findById(partner.getUsers().getId());
//    }
//
//    private void setUsersOnPartner(Partner partner, List<User>, boolean fromDatabase) {
//        if (listUsers.isPresent()) {
//            partner.setUsers(optionalUser.get());
//        }
//        else {
//            if (fromDatabase) {
//                throw new ServerSideException("Corrupt Data - no partner for user id:" + partner.getId());
//            }
//            else {
//                throw new NotFoundException("partner", null);
//            }
//        }
//    }

    @GetMapping
    @ResponseBody
    public List<Partner> getAllPartners() {
        List<Partner> result = new ArrayList<>();
        Iterable<Partner> iterable = partnerRepository.findAll();
        for (Partner partner : iterable) {
            result.add(partner);
        }
        return result;
    }

    @GetMapping("/{id}")
    public Partner getUser(@PathVariable Long id) {
        Optional<Partner> optionalPartner = partnerRepository.findById(id);
        if (optionalPartner.isPresent()) {
            return optionalPartner.get();
        } else {
            throw new NotFoundException("partner", id.toString());
        }
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable Long id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            partnerRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("partner", id.toString());
        }
    }

}
