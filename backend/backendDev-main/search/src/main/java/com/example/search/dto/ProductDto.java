package com.example.search.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private Integer id;
    private String name;
    private String imageUrl;
    private String dimension;
    private String weight;
    private String color;
    private String merchantId;
    private String categoryName;
    private Double price;
    private Double strikePrice;
    private String usp;
    private String description;
    private Integer quantity;
    private Integer soldQuantity;
    private Double rating;
    private Integer ratingCount;
}
