package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> findAllUsers(){
        return repository.findAll();
    }

    public User updateUser(Integer id,User newUser){

        Optional<User> optionalUser = repository.findById(id);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());

            return repository.save(user);
        }else{
            throw new RuntimeException("No User Found!");
        }
    }

    public User partialUpdateUser(Integer id, User newUser){

        Optional<User> optionalUser = repository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            if(newUser.getName() != null){
                user.setName(newUser.getName());
            }

            if(newUser.getEmail() != null){
                user.setEmail(newUser.getEmail());
            }

            return repository.save(user);
        }else{
            throw new RuntimeException("No User Found!");
        }
    }


    public User deleteUser(Integer id){
        Optional<User> optionalUser = repository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            repository.delete(user);
            return user;
        }else{
            throw new RuntimeException("No User Found!");
        }
    }






}
