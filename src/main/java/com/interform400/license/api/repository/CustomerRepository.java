package com.interform400.license.api.repository;

import com.interform400.license.api.entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "customers", path="customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Override
    Iterable<Customer> findAll();

    long count();

    Customer findCustomerByNameContains(String search);

//    Customer findCustomerByNameContains(String search);
}
