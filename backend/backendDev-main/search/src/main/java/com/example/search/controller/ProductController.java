package com.example.search.controller;


import com.example.search.dto.ProductDto;
import com.example.search.model.Product;
import com.example.search.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/{id}")
    public Optional<ProductDto> findById(@PathVariable("id") Integer id) {
        Optional<Product> optionalProduct = productService.findById(id);
        ProductDto productDto = null;
        if(optionalProduct.isPresent()) {
            productDto = new ProductDto();
            BeanUtils.copyProperties(optionalProduct.get(), productDto);
        }
        return Optional.ofNullable(productDto);
    }

    @GetMapping(value = "/productname/{name}")
    public List<ProductDto> findByName(@PathVariable("name") String name) {
        List<Product> productList = productService.findByName(name);
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = null;
        if (productList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < productList.size(); i++) {
            productDto = new ProductDto();
            BeanUtils.copyProperties(productList.get(i), productDto);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setRating(0.0);
        product.setRatingCount(0);
        product.setSoldQuantity(0);
        Product returnProduct = productService.save(product);
        ProductDto returnDto = new ProductDto();
        BeanUtils.copyProperties(returnProduct, returnDto);
        return returnDto;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        productService.deleteById(id);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        Iterable<Product> products = productService.findAll();
        return  products;
    }
}
