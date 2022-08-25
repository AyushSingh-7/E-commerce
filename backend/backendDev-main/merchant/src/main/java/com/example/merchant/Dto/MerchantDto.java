package com.example.merchant.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantDto {
    private Integer id;
    private String name;
    private String mailId;
    private String phoneNumber;
    private Integer totalProductsSold;
}
