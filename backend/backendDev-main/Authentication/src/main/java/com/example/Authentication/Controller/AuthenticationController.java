package com.example.Authentication.Controller;

import com.example.Authentication.Dto.AuthenticationDto;
import com.example.Authentication.Entity.Authentication;
import com.example.Authentication.Service.AuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/auth")
@CrossOrigin(value = "*")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

//    @GetMapping(value = "/{mail}")
//    public String findByMailId(@PathVariable("mail") String mail) {
//        Optional<Authentication> optionalAuthentication = authenticationService.findByMailId(mail);
//        AuthenticationDto authenticationDto = null;
//        if(optionalAuthentication.isPresent()){
//            return optionalAuthentication.get().password;
//        }
//        return null;
//    }



    @PostMapping(value="/login")
    public Authentication findByMailIdAndPassword(@RequestBody Authentication authentication) {
        Authentication optionalAuthentication = new Authentication();
        Authentication notOptionalAuthenticated = new Authentication();
        optionalAuthentication.setMailId(authentication.mailId);
        optionalAuthentication.setPassword(authentication.password);
        optionalAuthentication.setMerchant(authentication.isMerchant);
        optionalAuthentication.setCustomer(authentication.isCustomer);
        String pass = authenticationService.findByMailId(optionalAuthentication.mailId);
        if(pass.equals("error")) {
            return notOptionalAuthenticated;
        }
        String encryptCheck = "";
        for(int i=0; i<optionalAuthentication.password.length(); i++) {
            int c_value = optionalAuthentication.password.charAt(i);
            c_value =c_value + i + 1;
            char ca = (char) c_value;
            encryptCheck = encryptCheck + ca;
        }
        System.out.println(pass);
        if(encryptCheck.equals(pass)) {
            System.out.println(optionalAuthentication+"pass");
            return optionalAuthentication;
        }
        return notOptionalAuthenticated;

    }

    @PostMapping(value = "/registration")
    public Authentication save(@RequestBody AuthenticationDto authenticationDto) {
        Authentication authentication = new Authentication();
        Authentication notAuthenticated = new Authentication();
        BeanUtils.copyProperties(authenticationDto, authentication);
        boolean newCheck = authenticationService.isNewRegisterer(authentication.mailId, authentication);
        if(newCheck==true) {
            return notAuthenticated;
        }
        System.out.println(authentication+"aut");
        return authentication;
    }
}
