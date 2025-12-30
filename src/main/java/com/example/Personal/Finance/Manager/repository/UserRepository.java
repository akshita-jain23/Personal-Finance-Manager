package com.example.Personal.Finance.Manager.repository;

import com.example.Personal.Finance.Manager.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    void deleteById(String id);

    Optional<User> findByEmail(String email);
}
