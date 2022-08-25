package com.example.product.controller;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin(value = "*")
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

    @GetMapping(value = "/productname/{name}")
    public List<ProductDto> findByName(@PathVariable("name") String name){
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


    @GetMapping(value = "/categoryname/{name}")
    @CrossOrigin
    public List<ProductDto> findByCategoryName(@PathVariable("name") String name){
        List<Product> productList = productService.findByCategoryName(name);
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


    @GetMapping(value = "/merchant/{id}")
    public List<ProductDto> findByMercahntId(@PathVariable("id") String id) {
        List<Product> productList = productService.findByMerchantId(id);
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


    @PutMapping(value = "/quantity/{id}/{quantity}")
    public void updateQuantity(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity) {
        productService.updateQuantity(id, quantity);
    }


    @GetMapping(value = "/rec")
    public List<ProductDto> recommendation(){
        List<Product> productList = productService.recommendation();
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

    @PutMapping(value = "/update/{id}")
    public ProductDto updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDto productDto) {
        Optional<Product> optionalProduct = productService.findById(id);
        ProductDto updateProductDto = null;
        if(optionalProduct.isPresent()) {
            updateProductDto = new ProductDto();
            BeanUtils.copyProperties(optionalProduct.get(), updateProductDto);
        }
        updateProductDto.setImageUrl(productDto.getImageUrl());
        updateProductDto.setQuantity(productDto.getQuantity());
        updateProductDto.setDescription(productDto.getDescription());
        updateProductDto.setPrice(productDto.getPrice());
        updateProductDto.setStrikePrice(productDto.getStrikePrice());
        Product product = new Product();
        BeanUtils.copyProperties(updateProductDto, product);
        productService.save(product);
        return updateProductDto;
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

    @PutMapping(value = "/rating/{id}/{rating}")
    public ProductDto rate (@PathVariable("id") Integer id, @PathVariable("rating") Double rating) {
        Optional<Product> optionalProduct = productService.findById(id);
        ProductDto updateProductDto = null;
        if(optionalProduct.isPresent()) {
            updateProductDto = new ProductDto();
            BeanUtils.copyProperties(optionalProduct.get(), updateProductDto);
        }
        updateProductDto.setRatingCount(updateProductDto.getRatingCount()+1);
        Double rate = updateProductDto.getRating() + rating;
        rate = rate/2;
        updateProductDto.setRating(rate);
        Product product = new Product();
        BeanUtils.copyProperties(updateProductDto, product);
        productService.save(product);
        return updateProductDto;
    }
}
