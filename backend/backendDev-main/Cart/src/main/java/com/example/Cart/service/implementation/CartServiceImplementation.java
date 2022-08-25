package com.example.Cart.service.implementation;

import com.example.Cart.model.Cart;
import com.example.Cart.repository.CartRepository;
import com.example.Cart.service.CartService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteById(String id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> findByEmailId(String emailId) {
        return cartRepository.findByEmailId(emailId);
    }

    @Override
    public Optional<Cart> findById(String id) {
        return cartRepository.findById(id);
    }

//    @Override
//    public Optional<Cart> addQuantity(String id) {
//        return cartRepository.addQuantity(id);
//    }
//
//    @Override
//    public Optional<Cart> subQuantity(String id) {
//        return cartRepository.subQuantity(id);
//    }
}
