package com.example.Personal.Finance.Manager.controller;

import com.example.Personal.Finance.Manager.dto.UserDto;
import com.example.Personal.Finance.Manager.model.User;
import com.example.Personal.Finance.Manager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping
    public User createUser(@Valid @RequestBody UserDto user){
        return userservice.createUser(user);
    }
    @GetMapping
    public List<User> getAllUser(){
        return userservice.getAllUser();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable String id){
         userservice.deleteUser(id);
         return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable String id,@Valid @RequestBody UserDto user){
        userservice.updateUser(id,user);
        return ResponseEntity.ok().build();
    }
}
