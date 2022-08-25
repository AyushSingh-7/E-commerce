package com.example.Cart.dto;

import com.example.Cart.model.Cart;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class OrderDto {
    private String id;

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

    private List<CartDto> cartList;
    private Double price;
    private String mailId;
//    private String date;
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String dateCurrent) {
//        this.date=dateCurrent;
//    }
}
