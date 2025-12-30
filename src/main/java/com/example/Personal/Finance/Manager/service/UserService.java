package com.example.Personal.Finance.Manager.service;

import com.example.Personal.Finance.Manager.dto.UserDto;
import com.example.Personal.Finance.Manager.exception.CustomException;
import com.example.Personal.Finance.Manager.model.User;
import com.example.Personal.Finance.Manager.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private  UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user =  userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found" + email));
    return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
    }

public ResponseEntity<String> createUser( UserDto user){
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setName(user.getName());
        User userEntity = userRepository.save(user1);
        return  ResponseEntity.status(HttpStatus.CREATED).body(userEntity.toString());
}
//    public User createUser(UserDto user) {
//        User userEntity = new User(user);
//        return userRepository.save(userEntity);
//    }

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
    user.setPassword(dto.getPassword());
    userRepository.save(user);
    }
}
