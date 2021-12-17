package com.sergioarboleda.app.repositories;

import com.sergioarboleda.app.model.User;
import com.sergioarboleda.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository repository;


    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }


    public Optional<User>getUser(int id){
        return repository.findById(id);
    }
    
    public User create(User user) {
        return repository.save(user);
    }
    
    public void update(User user) {
        repository.save(user);
    }
    
    public void delete(User user) {
        repository.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = repository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
    
}
