package com.example.Personal.Finance.Manager.controller;

import com.example.Personal.Finance.Manager.dto.UserDTO;
import com.example.Personal.Finance.Manager.model.User;
import com.example.Personal.Finance.Manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User createUser = userService.createuser(userDTO);
                return ResponseEntity.created(
                        URI.create("/api/users/" + createUser.getId()))
                        .body(createUser);
    }

}
