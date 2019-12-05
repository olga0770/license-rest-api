package com.interform400.license.api.repository;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository of users
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);


    List<User> findAllByPartner(Partner partner);

}
