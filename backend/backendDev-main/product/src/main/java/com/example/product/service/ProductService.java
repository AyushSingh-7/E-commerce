package com.example.product.service;

import com.example.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Integer id);
    Product save(Product product);
    List<Product> findByName(String name);
    List<Product> findByCategoryName(String name);
    void updateQuantity(Integer id, Integer quantity);
    List<Product> recommendation();
    void deleteById(Integer id);
    List<Product> findByMerchantId(String id);
    Iterable<Product> findAll();
}
