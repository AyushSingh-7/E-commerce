package com.example.merchant.Dto;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
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
