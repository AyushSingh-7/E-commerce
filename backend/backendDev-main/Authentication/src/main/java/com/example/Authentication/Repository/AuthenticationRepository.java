package com.example.Authentication.Repository;

import com.example.Authentication.Entity.Authentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthenticationRepository extends CrudRepository<Authentication, String> {

    Authentication findByMailIdAndPassword(String mailId, String password);
    Optional<Authentication> findByMailId(String mail);

}
