package com.example.Cart.controller;

import com.example.Cart.dto.CartDto;
import com.example.Cart.dto.OrderDto;
import com.example.Cart.dto.ProductDto;
import com.example.Cart.model.Order;
import com.example.Cart.service.CartService;
import com.example.Cart.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
@CrossOrigin(value = "*")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @GetMapping(value = "id/{id}")
    public Optional<OrderDto> findById(@PathVariable("id") String id){
        Optional<Order> optionalOrder = orderService.findById(id);
        OrderDto orderDto = null;
        if (optionalOrder.isPresent()){
            orderDto = new OrderDto();
            BeanUtils.copyProperties(optionalOrder.get(), orderDto);
        }
        return Optional.ofNullable(orderDto);
    }

    @GetMapping(value = "/{mailId}")
    public List<OrderDto> findByMailId(@PathVariable("mailId") String mailId) {
        List<Order> orderList = orderService.findByMailId(mailId);
        List<OrderDto> orderDtoList = new ArrayList<>();
        OrderDto orderDto = null;
        if(orderList.isEmpty()) {
            System.out.println("It's Empty");
            return null;
        }
        for (int i=0; i<orderList.size();i++) {
            orderDto = new OrderDto();
            BeanUtils.copyProperties(orderList.get(i), orderDto);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    @PostMapping
    public OrderDto save (@RequestBody OrderDto orderDto) {
        Order order = new Order();
        Double price = 0.0;
        for(int i=0; i<orderDto.getCartList().size();i++){
            CartDto cart = orderDto.getCartList().get(i);
            Double cartPrice = cart.getProductDto().getPrice() * cart.getQuantity();
            price = price + cartPrice;
            RestTemplate restTemplate = new RestTemplate();

            String resourceUrl = "http://localhost:8080/product/quantity/"+cart.getProductId()+"/"+cart.getQuantity();
            restTemplate.put(resourceUrl, void.class);

            String merchantUrl = "http://localhost:8083/merchant/addCount/"+cart.getProductId()+"/"+cart.getQuantity();
            restTemplate.put(merchantUrl, void.class);

            cartService.deleteById(cart.getId());
        }
        orderDto.setPrice(price);
        Date date = new Date();
        String dateCurrent = date.toString();
        System.out.println(dateCurrent);
//        orderDto.setDate(dateCurrent);
        BeanUtils.copyProperties(orderDto, order);
        Order returnOrder = orderService.save(order);

        RestTemplate restTemplate = new RestTemplate();
        String mailUrl = "http://localhost:8085/sendmail/"+returnOrder.getMailId();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(mailUrl , String.class);

        OrderDto returnOrderDto = new OrderDto();
        BeanUtils.copyProperties(returnOrder,returnOrderDto);
        return returnOrderDto;
    }

}