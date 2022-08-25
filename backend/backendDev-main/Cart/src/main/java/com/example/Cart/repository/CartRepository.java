package com.example.Cart.repository;

import com.example.Cart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    List<Cart> findByEmailId(String emailId);

//    Optional<Cart> addQuantity(String id);
//
//    Optional<Cart> subQuantity(String id);

}
