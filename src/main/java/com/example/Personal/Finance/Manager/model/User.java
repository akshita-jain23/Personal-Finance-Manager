package com.example.Personal.Finance.Manager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
