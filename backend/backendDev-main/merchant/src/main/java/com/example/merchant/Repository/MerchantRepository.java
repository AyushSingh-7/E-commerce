package com.example.merchant.Repository;

import com.example.merchant.Entity.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,Integer> {
}
