package com.example.Personal.Finance.Manager.dto;

import com.example.Personal.Finance.Manager.constant.Category;
import com.example.Personal.Finance.Manager.constant.TransactionType;
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
    private Category category;
    @NotBlank
    private TransactionType transactionType;
    private int amount;
    private String account;
    private String description;
    private ZonedDateTime date;

}
