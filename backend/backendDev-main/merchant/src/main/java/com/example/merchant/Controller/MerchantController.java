package com.example.merchant.Controller;

import com.example.merchant.Dto.MerchantDto;
import com.example.merchant.Dto.ProductDto;
import com.example.merchant.Entity.Merchant;
import com.example.merchant.Service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @GetMapping(value = "/{id}")
    public Optional<MerchantDto> findById(@PathVariable("id") Integer id) {
        Optional<Merchant> optionalMerchant = merchantService.findById(id);
        MerchantDto merchantDto = null;
        if(optionalMerchant.isPresent()) {
            merchantDto = new MerchantDto();
            BeanUtils.copyProperties(optionalMerchant.get(), merchantDto);
        }
        return Optional.ofNullable(merchantDto);
    }

    @PostMapping
    public MerchantDto save(@RequestBody MerchantDto merchantDto) {
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(merchantDto, merchant);
        merchant.setTotalProductsSold(0);
        Merchant returnMerchant = merchantService.save(merchant);
        MerchantDto returnDto = new MerchantDto();
        BeanUtils.copyProperties(returnMerchant, returnDto);
        return returnDto;
    }

    @PutMapping(value = "/addCount/{id}/{quan}")
    public void productsSold(@PathVariable("id")Integer id, @PathVariable("quan") Integer quan) {
        Optional<Merchant> optionalMerchant = merchantService.findById(id);
        MerchantDto merchantDto = null;
        if(optionalMerchant.isPresent()) {
            merchantDto = new MerchantDto();
            optionalMerchant.get().setTotalProductsSold(optionalMerchant.get().getTotalProductsSold()+quan);
            BeanUtils.copyProperties(optionalMerchant.get(), merchantDto);
        }
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(merchantDto, merchant);
        merchantService.save(merchant);
    }
}
