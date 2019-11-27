package com.interform400.license.api.repository;

import com.interform400.license.api.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Repository of users
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Override
    Iterable<User> findAll();
    long count();

}
