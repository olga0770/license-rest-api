package com.interform400.license.api.controller;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import com.interform400.license.api.exception.NotFoundException;
import com.interform400.license.api.repository.PartnerRepository;
import com.interform400.license.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/partners")
@SuppressWarnings({"squid:S2629","squid:S3457"})
public class PartnerController {

    private final PartnerRepository partnerRepository;
    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(PartnerController.class);


    @Autowired
    public PartnerController(PartnerRepository partnerRepository, UserRepository userRepository) {
        this.partnerRepository = partnerRepository;
        this.userRepository = userRepository;
    }


    @GetMapping
    @ResponseBody
    public List<Partner> getAllPartners() {
        List<Partner> result = new ArrayList<>();
        Iterable<Partner> iterable = partnerRepository.findAll();
        for (Partner partner : iterable) {
            // avoid a very large and not-needed response object
            partner.setUsers(new ArrayList<>());
            result.add(partner);
        }
        return result;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Partner getPartner(@PathVariable Long id) {
        logger.info("getPartner:" + id);

        Optional<Partner> optionalPartner = partnerRepository.findById(id);
        if (optionalPartner.isPresent()) {
            Partner result = optionalPartner.get();
            // to prevent infinite recursion
            for (User user: result.getUsers()) {
                user.setPartner(null);
            }
            return result;
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

    @DeleteMapping("/delete_all_including_users/{id}")
    public void deletePartnerWithRelations(@PathVariable Long id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            for (User user: partner.get().getUsers()) {
                userRepository.deleteById(user.getId());
            }
            partnerRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("partner", id.toString());
        }
    }


}
