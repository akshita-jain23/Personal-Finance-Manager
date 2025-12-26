package com.example.Personal.Finance.Manager.controller;

import com.example.Personal.Finance.Manager.dto.TransactionDto;
import com.example.Personal.Finance.Manager.model.Transaction;
import com.example.Personal.Finance.Manager.repository.TransactionRepository;
import com.example.Personal.Finance.Manager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/users/{userId}")
    public List<Transaction> getAllTransaction(@PathVariable String userId) {
        return transactionService.getAllTransaction(userId);
    }
    @PostMapping("/users/{userId}")
    public ResponseEntity<Transaction> createTransaction(@PathVariable String userId, @RequestBody TransactionDto dto) {
        return ResponseEntity.ok(transactionService.createTransaction(userId,dto));
    }
    @PutMapping("/users/{userId}/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable String userId, @PathVariable String transactionId, @RequestBody TransactionDto dto) {
        return ResponseEntity.ok(transactionService.updateTransactionById(userId,transactionId,dto));
    }
    @DeleteMapping("/users/{userId}/{transactionId}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable String userId, @PathVariable String transactionId) {
        return  transactionService.deleteTransactionById(userId,transactionId);
    }



}
