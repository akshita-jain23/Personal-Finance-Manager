package com.example.Personal.Finance.Manager.service;

import com.example.Personal.Finance.Manager.dto.UserDto;
import com.example.Personal.Finance.Manager.exception.CustomException;
import com.example.Personal.Finance.Manager.model.User;
import com.example.Personal.Finance.Manager.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;


    public User createUser(UserDto user) {
        User userEntity = new User(user);
        return userRepository.save(userEntity);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new CustomException.UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
    public void updateUser(String id,@Valid UserDto dto ) {
 User user = userRepository.findById(id).orElseThrow(()-> new CustomException.UserNotFoundException(id));
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    userRepository.save(user);
    }
}
