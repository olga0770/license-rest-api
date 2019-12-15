package com.interform400.license.api.controller;

import com.interform400.license.api.controller.request.CreateUpdatePartnerRequest;
import com.interform400.license.api.controller.response.PartnerDataResponse;
import com.interform400.license.api.service.PartnerService;
import com.interform400.license.api.service.data.PartnerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The Partner REST controller.
 * Responsible for receiving requests from external HTTP clients, and deliver a response.
 */
@RestController
@RequestMapping("/partners")
@SuppressWarnings({"squid:S2629","squid:S3457"})
public class PartnerController {

    private final PartnerService partnerService;

    Logger logger = LoggerFactory.getLogger(PartnerController.class);


    @Autowired
    public PartnerController(PartnerService partnerService) {
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

    @DeleteMapping("/delete-all-including-users/{id}")
    public void deletePartnerWithRelations(@PathVariable Long id) {
        logger.info("deletePartnerWithRelations():" + id);

        partnerService.deletePartnerWithRelations(id);
    }

    @PostMapping
    @ResponseBody
    public PartnerDataResponse createPartner(@RequestBody CreateUpdatePartnerRequest createPartnerRequest) {
        logger.info("calling createPartner:" + createPartnerRequest.getCompanyName() + ":" + createPartnerRequest.getCompanyName());

        return new PartnerDataResponse(partnerService.createPartner(createPartnerRequest));
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public PartnerDataResponse updatePartner(@PathVariable Long id, @RequestBody CreateUpdatePartnerRequest updatePartnerRequest) {
        return new PartnerDataResponse(partnerService.updatePartner(id, updatePartnerRequest));
    }


}
