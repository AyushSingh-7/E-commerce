package com.example.search.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@ToString
@Document(indexName = "product",shards = 2)
@Data
public class Product {

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

    public void setRating(double v) {
    }

    public void setRatingCount(int i) {
    }

    public void setSoldQuantity(int i) {
    }
}
