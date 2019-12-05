package com.interform400.license.api.repository;

import com.interform400.license.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository of users
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
