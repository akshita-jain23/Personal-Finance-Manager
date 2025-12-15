package com.example.Personal.Finance.Manager.service;

import com.example.Personal.Finance.Manager.dto.UserDTO;
import com.example.Personal.Finance.Manager.model.User;
import com.example.Personal.Finance.Manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;


    public User createuser(UserDTO userDTO){
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
        }
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

}
