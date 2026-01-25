package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/createUser")
    public User createUser(@Valid @RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return service.findAllUsers();
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@Valid @RequestBody User user,@PathVariable Integer id){
        return service.updateUser(id,  user);
    }

    @PatchMapping("/partialUpdateUser/{id}")
    public User partialUpdateUser(@Valid @PathVariable Integer id,@RequestBody User user){
        return service.partialUpdateUser(id, user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
    }



}
