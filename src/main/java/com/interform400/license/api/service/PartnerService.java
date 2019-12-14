package com.interform400.license.api.service;

import com.interform400.license.api.controller.request.CreatePartnerRequest;
import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import com.interform400.license.api.exception.NotFoundException;
import com.interform400.license.api.repository.PartnerRepository;
import com.interform400.license.api.repository.UserRepository;
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
@SuppressWarnings({"squid:S2629", "squid:S3457", "unused"})
public class PartnerService {

    private final PartnerRepository partnerRepository;
    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(PartnerService.class);


    @Autowired
    public PartnerService(PartnerRepository partnerRepository, UserRepository userRepository) {
        this.partnerRepository = partnerRepository;
        this.userRepository = userRepository;
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


    @SuppressWarnings("ResultOfMethodCallIgnored")
    public PartnerData getPartner(Long id) {
        logger.info("getPartner():" + id);

        Optional<Partner> optionalPartner = partnerRepository.findById(id);
        if (optionalPartner.isPresent()) {
            Partner result = optionalPartner.get();
            result.getUsers();  // to ensure that we see the users in the result object (in case of lazy ORM)
            return new PartnerData(result);
        }
        else {
            throw new NotFoundException("partner", id.toString());
        }
    }

    public void deletePartnerWithRelations(Long id) {
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


    public PartnerData createPartner(CreatePartnerRequest createPartnerRequest) {
        Partner partner = new Partner();
        partner.setCompanyName(createPartnerRequest.getCompanyName());
        partnerRepository.save(partner);

        return new PartnerData(partner);
    }
}
