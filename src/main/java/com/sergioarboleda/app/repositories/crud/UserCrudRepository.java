package com.sergioarboleda.app.repositories.crud;

import com.sergioarboleda.app.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);
            
    Optional<User> findByEmailAndPassword(String email, String password);
    
    
    }
