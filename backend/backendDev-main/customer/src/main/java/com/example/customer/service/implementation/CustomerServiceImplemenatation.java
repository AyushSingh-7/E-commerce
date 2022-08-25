package com.example.customer.service.implementation;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImplemenatation implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Optional<Customer> findByEmailId(String email) {
        return customerRepository.findByEmailId(email);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

}
