package com.example.Cart.model;

import com.example.Cart.dto.CartDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private String id;
    private List<CartDto> cartList;
    private Double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CartDto> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartDto> cartList) {
        this.cartList = cartList;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    private String mailId;
}
