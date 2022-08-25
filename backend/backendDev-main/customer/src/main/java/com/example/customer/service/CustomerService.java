package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findByEmailId(String Email);

    Customer save (Customer customer);
}
