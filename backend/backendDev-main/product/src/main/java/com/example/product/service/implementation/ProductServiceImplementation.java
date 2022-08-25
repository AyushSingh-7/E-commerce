package com.example.product.service.implementation;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByCategoryName(String name) {
        return productRepository.findByCategoryName(name);
    }

    @Override
    public void updateQuantity(Integer id, Integer quantity) {
        productRepository.updateQuantity(id, quantity);
    }
    @Override
    public List<Product> recommendation() {
        return productRepository.recommendation();
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByMerchantId(String id) {
        return productRepository.findByMerchantId(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

}
