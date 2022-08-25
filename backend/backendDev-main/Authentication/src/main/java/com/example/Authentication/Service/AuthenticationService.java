package com.example.Authentication.Service;

import com.example.Authentication.Entity.Authentication;

import java.util.Optional;

public interface AuthenticationService {
    Authentication findByMailIdAndPassword(String mailId, String password);
    Authentication save(Authentication authentication);
    String findByMailId(String mail);
    boolean isNewRegisterer(String mailId,Authentication authentication);


}
