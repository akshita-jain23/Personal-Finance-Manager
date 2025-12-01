package com.example.Personal.Finance.Manager.controller;

import com.example.Personal.Finance.Manager.dto.TransactionDTO;
import com.example.Personal.Finance.Manager.model.Transaction;
import com.example.Personal.Finance.Manager.repository.TransactionRepository;
import com.example.Personal.Finance.Manager.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor

public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/{userId}")
    public ResponseEntity<Transaction> createTransaction(@PathVariable String userId, @RequestBody TransactionDTO transactionDTO) {
        Transaction createTransaction = transactionService.create(transactionDTO, userId);
        return ResponseEntity.ok(createTransaction);
    }}
