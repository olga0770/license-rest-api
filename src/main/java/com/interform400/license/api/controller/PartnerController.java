package com.interform400.license.api.controller;

import com.interform400.license.api.controller.response.PartnerDataResponse;
import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import com.interform400.license.api.exception.NotFoundException;
import com.interform400.license.api.repository.PartnerRepository;
import com.interform400.license.api.repository.UserRepository;
import com.interform400.license.api.service.PartnerService;
import com.interform400.license.api.service.data.PartnerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Partner REST controller.
 * Responsible for receiving requests from external HTTP clients, and deliver a response.
 */
@RestController
@RequestMapping("/partners")
@SuppressWarnings({"squid:S2629","squid:S3457"})
public class PartnerController {

    private final PartnerRepository partnerRepository;
    private final UserRepository userRepository;

    private final PartnerService partnerService;

    Logger logger = LoggerFactory.getLogger(PartnerController.class);


    @Autowired
    public PartnerController(PartnerRepository partnerRepository, UserRepository userRepository, PartnerService partnerService) {
        this.partnerRepository = partnerRepository;
        this.userRepository = userRepository;
        this.partnerService = partnerService;
    }


    @GetMapping
    @ResponseBody
    public List<PartnerDataResponse> getAllPartners() {
        logger.info("getAllPartners():");

        List<PartnerDataResponse> result = new ArrayList<>();

        for (PartnerData partnerData : partnerService.getAllPartners()) {
            result.add(new PartnerDataResponse(partnerData));
        }

        return result;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PartnerDataResponse getPartner(@PathVariable Long id) {
        logger.info("getPartner():" + id);

        return new PartnerDataResponse(partnerService.getPartner(id));
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
