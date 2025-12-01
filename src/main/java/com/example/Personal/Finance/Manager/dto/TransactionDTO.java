package com.example.Personal.Finance.Manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Double amount;
    private LocalDate date;
    private String category;
    private String type;
    private String notes;
}
