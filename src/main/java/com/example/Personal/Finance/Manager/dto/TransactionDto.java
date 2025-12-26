package com.example.Personal.Finance.Manager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.ZonedDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    @NotBlank
    private String category;
    private int amount;
    private String account;
    private String description;
    private ZonedDateTime date;

}
