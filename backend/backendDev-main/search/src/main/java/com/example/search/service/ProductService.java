package com.example.search.service;

import com.example.search.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService{
    Optional<Product> findById(Integer id);
    Product save(Product product);
    void deleteById(Integer id);
    Iterable<Product> findAll();
    List<Product> findByName(String name);
}
