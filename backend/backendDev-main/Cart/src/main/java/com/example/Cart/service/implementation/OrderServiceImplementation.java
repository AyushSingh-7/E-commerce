package com.example.Cart.service.implementation;

import com.example.Cart.repository.OrderRepository;
import com.example.Cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Optional<com.example.Cart.model.Order> findById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public com.example.Cart.model.Order save(com.example.Cart.model.Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<com.example.Cart.model.Order> findByMailId(String mailId) {
        return orderRepository.findByMailId(mailId);
    }
}
