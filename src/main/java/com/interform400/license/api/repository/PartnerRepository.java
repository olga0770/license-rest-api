package com.interform400.license.api.repository;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository of partners
 */
@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long> {
    Partner findAllByCompanyName(String companyName);
}
