package com.example.Authentication.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authentication2")
public class Authentication {
    @Id
    public String mailId;
    public String password;
    public boolean isMerchant;
    public boolean isCustomer;

    public String getMailId() {
        return mailId;

    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMerchant() {
        return isMerchant;
    }

    public void setMerchant(boolean merchant) {
        isMerchant = merchant;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                ", mailId='" + mailId + '\'' +
                ", password='" + password + '\'' +
                ", isMerchant=" + isMerchant +
                ", isCustomer=" + isCustomer +
                '}';
    }
}
