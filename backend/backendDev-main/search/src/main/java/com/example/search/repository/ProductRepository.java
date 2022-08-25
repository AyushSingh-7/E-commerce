package com.example.search.repository;

import com.example.search.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {

    List<Product> findByName(String name);
}
