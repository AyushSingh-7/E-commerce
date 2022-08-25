package com.example.Authentication.Service.impl;

import com.example.Authentication.Dto.AuthenticationDto;
import com.example.Authentication.Entity.Authentication;
import com.example.Authentication.Repository.AuthenticationRepository;
import com.example.Authentication.Service.AuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
     AuthenticationRepository authenticationRepository;


    @Override
    public Authentication findByMailIdAndPassword(String mailId, String password) {
        return authenticationRepository.findByMailIdAndPassword(mailId,password);
    }

    @Override
    public String findByMailId(String mail) {
        Optional<Authentication> optionalAuthentication=authenticationRepository.findByMailId(mail);
//        System.out.println(optionalAuthentication.get().isMerchant);
        if(optionalAuthentication.isPresent())
        {
            return optionalAuthentication.get().getPassword();
        }
//        else if(optionalAuthentication.isPresent() && optionalAuthentication.get().isMerchant==false && optionalAuthentication.get().isCustomer==true)
//        {
//            return optionalAuthentication.get().getPassword();
//        }
        return "error";
    }

    @Override
    public boolean isNewRegisterer(String mailId,Authentication authentication){
        Optional<Authentication> optionalAuthentication = authenticationRepository.findByMailId(mailId);
        if(optionalAuthentication.isPresent()) {
            return true;
        }
        String encrypt = "";
        //String decrypt = "";
        for (int i = 0; i < authentication.password.length(); i++) {
            int value = authentication.password.charAt(i);
            value = value + i + 1;
            char a = (char) value;
            encrypt = encrypt + a;
        }
        Boolean b1 = new Boolean("true");
        boolean b = b1.booleanValue();
        authentication.setPassword(encrypt);
        System.out.println(encrypt);
        Authentication returnAuthentication = save(authentication);
        AuthenticationDto returnDto = new AuthenticationDto();
//        for(int i=authentication.password.length()-1; i>=0; i--)
//        {
//            int d_value = authentication.password.charAt(i);
//            d_value = d_value - i -1;
//            char ad = (char) d_value;
//            decrypt = ad+decrypt;
//        }
        BeanUtils.copyProperties(returnAuthentication, returnDto);
        return false;
    }

    @Override
    public Authentication save(Authentication authentication) {
        return authenticationRepository.save(authentication);
    }
}
