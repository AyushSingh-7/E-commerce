package com.example.Cart.service;

import com.example.Cart.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart save(Cart cart);
    void deleteById (String id);
    List<Cart> findByEmailId(String emailId);
    Optional<Cart> findById(String id);
//    Optional<Cart> addQuantity(String id);
//    Optional<Cart> subQuantity(String id);
}
