package com.interform400.license.api.service;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import com.interform400.license.api.exception.NotFoundException;
import com.interform400.license.api.repository.PartnerRepository;
import com.interform400.license.api.service.data.PartnerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * The Partner service class.
 * Responsible for encapsulating the partner data and make it available for different clients,
 * e.g. REST controllers, HTML controllers, XML web services, etc.
 */
@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;

    Logger logger = LoggerFactory.getLogger(PartnerService.class);


    @Autowired
    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public List<PartnerData> getAllPartners() {
        logger.info("getAllPartners():");

        List<PartnerData> result = new ArrayList<>();
        Iterable<Partner> iterable = partnerRepository.findAll();
        for (Partner partner : iterable) {
            result.add(new PartnerData(partner));
        }
        return result;
    }


    public PartnerData getPartner(Long id) {
        logger.info("getPartner():" + id);

        Optional<Partner> optionalPartner = partnerRepository.findById(id);
        if (optionalPartner.isPresent()) {
            Partner result = optionalPartner.get();

            result.getUsers();  // to ensure that we see the users in the result object (in case of lazy ORM)
//            for (User user: result.getUsers()) {
//                //user.setPartner(null);
//            }
            return new PartnerData(result);
        }
        else {
            throw new NotFoundException("partner", id.toString());
        }
    }

}
