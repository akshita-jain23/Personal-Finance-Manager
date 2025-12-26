package com.example.Personal.Finance.Manager.model;

import com.example.Personal.Finance.Manager.dto.UserDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotBlank
    private String name;
    @Email
    @Indexed(unique = true)
    @NotBlank
    private String email;
//    private String password;
    public User(UserDto Dto) {
        this.name = Dto.getName();
        this.email = Dto.getEmail();
    }
}
