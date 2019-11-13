package com.interform400.license.api.repository;

import com.interform400.license.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Repository of users
 */
@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "users", path="users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Override
    Iterable<User> findAll();
    long count();


    // User findByUsername(String username);

    Iterable<User> findAllByUsernameContains(String search);

    // Iterable<User> findUsersByUsernameAndId(String name, Long id);



}
