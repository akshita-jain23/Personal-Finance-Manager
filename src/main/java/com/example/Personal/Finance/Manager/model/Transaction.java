package com.example.Personal.Finance.Manager.model;

import com.example.Personal.Finance.Manager.constant.Category;
import com.example.Personal.Finance.Manager.constant.TransactionType;
import com.example.Personal.Finance.Manager.dto.TransactionDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private Category category;
    private int amount;
    private TransactionType transactionType;
    @NotBlank
    private String account;
    private String description;
     private ZonedDateTime date;
     @Indexed
     private String userId;

    public void updateFromDto(TransactionDto dto) {
        this.category = dto.getCategory();
        this.amount = dto.getAmount();
        this.account = dto.getAccount();
        this.description = dto.getDescription();
    }

}
