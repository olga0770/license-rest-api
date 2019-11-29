package com.interform400.license.api.controller;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerController(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }


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

}
