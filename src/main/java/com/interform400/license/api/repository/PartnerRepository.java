package com.interform400.license.api.repository;

import com.interform400.license.api.entity.Partner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Repository of partners
 */
@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "partners", path="partners")
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long> {
    @Override
    Iterable<Partner> findAll();
    long count();

    Iterable<Partner> findAllByCompanyNameContains(String search);
}
