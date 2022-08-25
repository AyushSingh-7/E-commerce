package com.example.merchant.Service.impl;

import com.example.merchant.Entity.Merchant;
import com.example.merchant.Repository.MerchantRepository;
import com.example.merchant.Service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public Optional<Merchant> findById(Integer id) {
        return merchantRepository.findById(id);
    }

    @Override
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }
}
