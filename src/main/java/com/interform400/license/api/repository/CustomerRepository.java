package com.interform400.license.api.repository;

import com.interform400.license.api.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Override
    Iterable<Customer> findAll();

    long count();
}
