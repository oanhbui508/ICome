package com.test.demo.service;

import com.test.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    Optional<Customer> findById(Long id);

    Optional<Customer> findByFacebookId(String facebookId);

    Optional<Customer> findByName(String name);

    List<Customer> findAll();

    Customer save(Customer customer);

    void deleteById(Long id);
}
