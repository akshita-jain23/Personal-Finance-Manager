package com.example.Personal.Finance.Manager.repository;

import com.example.Personal.Finance.Manager.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
