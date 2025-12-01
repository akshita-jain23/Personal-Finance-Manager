package com.example.Personal.Finance.Manager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("Transactions")
public class Transaction {
    @Id
    private String id;
    private String userId  ;
    private Double amount;
    private LocalDate date;
    private String category;
    private String type;
    private String notes;
}
