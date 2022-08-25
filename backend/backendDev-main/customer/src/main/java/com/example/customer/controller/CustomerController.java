package com.example.customer.controller;

import com.example.customer.dto.CustomerDto;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(value="*")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{email}")
    public Optional<CustomerDto> findByEmailId(@PathVariable("email") String email) {
        Optional<Customer> optionalCustomer = customerService.findByEmailId(email);
        CustomerDto customerDto = null;
        if (optionalCustomer.isPresent()){
            customerDto = new CustomerDto();
            BeanUtils.copyProperties(optionalCustomer.get(), customerDto);
        }
        return Optional.ofNullable(customerDto);
    }

    @PostMapping
    public CustomerDto save(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        Optional<Customer> optionalCustomer = customerService.findByEmailId(customerDto.getEmailId());
        if (optionalCustomer.isPresent()){
            return null;
        } else {
            Customer returnCustomer = customerService.save(customer);
            CustomerDto returnDto = new CustomerDto();
            BeanUtils.copyProperties(returnCustomer, returnDto);
            return returnDto;
        }
    }

    @PutMapping (value = "/update/{emailId}")
    public CustomerDto update(@PathVariable ("emailId") String emailId, @RequestBody CustomerDto customerDto) {
        Optional<Customer> optionalCustomer = customerService.findByEmailId(emailId);
        CustomerDto updateCustomerDto = null;
        if(optionalCustomer.isPresent()) {
            updateCustomerDto = new CustomerDto();
            BeanUtils.copyProperties(optionalCustomer.get(), updateCustomerDto);
        }
        updateCustomerDto.setAddress(customerDto.getAddress());
        updateCustomerDto.setContactNumber(customerDto.getContactNumber());
        updateCustomerDto.setName(customerDto.getName());

        Customer customer = new Customer();
        BeanUtils.copyProperties(updateCustomerDto, customer);
        customerService.save(customer);
        return updateCustomerDto;
    }
}
