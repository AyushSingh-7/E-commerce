package com.example.merchant.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Merchant")
@Getter
@Setter
@ToString
public class Merchant {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String mailId;
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTotalProductsSold() {
        return totalProductsSold;
    }

    public void setTotalProductsSold(Integer totalProductsSold) {
        this.totalProductsSold = totalProductsSold;
    }

    private Integer totalProductsSold;
}
