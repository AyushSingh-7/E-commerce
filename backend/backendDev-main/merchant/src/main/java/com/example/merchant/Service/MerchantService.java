package com.example.merchant.Service;

import com.example.merchant.Entity.Merchant;

import java.util.Optional;

public interface MerchantService {
    Optional<Merchant> findById(Integer id);
    Merchant save(Merchant merchant);

}
