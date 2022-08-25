package com.example.Cart.service;

import com.example.Cart.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Optional<Order> findById (String id);
    public Order save (Order order);
    List<Order> findByMailId(String mailId);

}
