package com.example.Cart.controller;

import com.example.Cart.dto.CartDto;
import com.example.Cart.dto.ProductDto;
import com.example.Cart.model.Cart;
import com.example.Cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "cart")
@CrossOrigin(value = "*")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping(value = "/{emailId}")
    public List<CartDto> findByEmailId(@PathVariable("emailId") String emailId) {
        List<Cart> cartList = cartService.findByEmailId(emailId);
        List<CartDto> cartDtoList = new ArrayList<>();
        CartDto cartDto = null;
        if(cartList.isEmpty()) {
            return cartDtoList;
        }
        for (int i=0; i<cartList.size();i++) {
            cartDto = new CartDto();
            BeanUtils.copyProperties(cartList.get(i), cartDto);
            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl = "http://localhost:8080/product/"+cartList.get(i).getProductId();
            System.out.println(resourceUrl);
            ResponseEntity<ProductDto> responseEntity = restTemplate.getForEntity(resourceUrl, ProductDto.class);
            cartDto.setProductDto(responseEntity.getBody());
            cartDtoList.add(cartDto);
        }
        return cartDtoList;
    }

    @GetMapping(value = "/cartid/{id}")
    public Optional<CartDto> findById(@PathVariable("id") String id) {
        Optional<Cart> optionalCart = cartService.findById(id);
        CartDto cartDto = null;
        if (optionalCart.isPresent()){
            cartDto = new CartDto();
            BeanUtils.copyProperties(optionalCart.get(), cartDto);
        }
        return Optional.ofNullable(cartDto);
    }

    @PostMapping
    public CartDto save (@RequestBody CartDto cartDto) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDto, cart);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/product/"+cart.getProductId();
        System.out.println(resourceUrl);
        ResponseEntity<ProductDto> responseEntity = restTemplate.getForEntity(resourceUrl, ProductDto.class);
//        System.out.println(responseEntity+"jello");
        cart.setProductDto(responseEntity.getBody());
        Cart returnCart = cartService.save(cart);
        CartDto returnDto = new CartDto();
        BeanUtils.copyProperties(returnCart, returnDto);
        return returnDto;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") String id) {
        cartService.deleteById(id);
    }


    @PutMapping(value = "/add/{id}")
    public Optional<CartDto> addQuantity(@PathVariable("id") String id) {
        Optional<Cart> optionalCart = cartService.findById(id);
        CartDto cartDto = null;
        Cart cart = new Cart();
        if(optionalCart.isPresent()) {
            cartDto = new CartDto();
            BeanUtils.copyProperties(optionalCart.get(), cartDto);
            if(cartDto.getProductDto().getQuantity()>=cartDto.getQuantity()) {
                System.out.println(true);
                cartDto.setQuantity(cartDto.getQuantity()+1);
            } else {
                System.out.println(false);
            }
        }
        BeanUtils.copyProperties(cartDto, cart);
        Cart returnCart = cartService.save(cart);
        CartDto returnDto = new CartDto();
        BeanUtils.copyProperties(returnCart, returnDto);
        return Optional.ofNullable(returnDto);
    }

    @PutMapping(value = "/sub/{id}")
    public Optional<CartDto> subQuantity(@PathVariable("id") String id) {
        Optional<Cart> optionalCart = cartService.findById(id);
        CartDto cartDto = null;
        Cart cart = new Cart();
        if(optionalCart.isPresent()) {
            cartDto = new CartDto();
            BeanUtils.copyProperties(optionalCart.get(), cartDto);
            if(cartDto.getQuantity()>=2) {
                System.out.println(true);
                cartDto.setQuantity(cartDto.getQuantity()-1);
            } else {
                System.out.println(false);
            }
        }
        BeanUtils.copyProperties(cartDto, cart);
        Cart returnCart = cartService.save(cart);
        CartDto returnDto = new CartDto();
        BeanUtils.copyProperties(returnCart, returnDto);
        return Optional.ofNullable(returnDto);
    }

    @GetMapping(value = "/check/{emailId}/{productId}")
    public boolean checkCart (@PathVariable("productId") Integer productId, @PathVariable("emailId") String emailId) {
        List<Cart> cartList = cartService.findByEmailId(emailId);
        if (cartList.isEmpty()){
            return false;
        } else {
            for (int i=0;i<cartList.size();i++){
                if(cartList.get(i).getProductId().equals(productId)) {
                    return true;
                }
            }
        }
        return false;
    }
}