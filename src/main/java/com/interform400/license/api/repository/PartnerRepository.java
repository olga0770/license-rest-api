package com.interform400.license.api.repository;

import com.interform400.license.api.entity.Partner;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository of partners
 */
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long> {
    @Override
    Iterable<Partner> findAll();
    long count();

    Iterable<Partner> findAllByCompanyNameContains(String search);
}
