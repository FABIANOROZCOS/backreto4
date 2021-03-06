package com.sergioarboleda.app.services;

import com.sergioarboleda.app.model.User;
import com.sergioarboleda.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll(){
        return repository.getAll();
    }
    
    public Optional<User> getUser(int id){
        return repository.getUser(id);
    
    }

   
    public User create(User user){
        if (user.getId() == null){
            return user;
        }else {
            Optional<User> e = repository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail())==false){
                    return repository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    
    
    public User update(User user){
        
        if (user.getId() != null) {
            Optional<User> userDb = repository.getUser(user.getId());
            if(!userDb.isEmpty()){
                if(user.getIdentification()!= null){
                    userDb.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!= null){
                    userDb.get().setName(user.getName());
                }
                if(user.getBirthtDay()!= null){
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                if(user.getMonthBirthtDay()!= null){
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if(user.getAddress()!= null){
                    userDb.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!= null){
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!= null){
                    userDb.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!= null){
                    userDb.get().setPassword(user.getPassword());
                }
                if(user.getZone()!= null){
                    userDb.get().setZone(user.getZone());
                }
                if(user.getType()!= null){
                    userDb.get().setType(user.getType());
                }
            
                repository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean delete(int userId){
        Boolean aBoolean = getUser(userId).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public boolean emailExists(String email) {
        return repository.emailExists(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = repository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    
    
    
}
