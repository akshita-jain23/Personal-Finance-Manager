package com.example.Personal.Finance.Manager.controller;

import com.example.Personal.Finance.Manager.dto.TransactionDTO;
import com.example.Personal.Finance.Manager.model.Transaction;
import com.example.Personal.Finance.Manager.repository.TransactionRepository;
import com.example.Personal.Finance.Manager.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor

public class TransactionController {
    @Autowired
    private TransactionService transactionService;

@PostMapping()
public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO dto, Principal principal) {
    String userId = principal.getName();
    Transaction createTransaction = transactionService.create(dto, userId);
    return ResponseEntity.ok(createTransaction) ;
}

@GetMapping()
public ResponseEntity<List<Transaction>> getAllTransactions(Principal principal) {
    String userId = principal.getName();
    List<Transaction> list = transactionService.getByUserId(userId);
    return ResponseEntity.ok().body(list);
}

@PutMapping("/{id}")
public  ResponseEntity<Transaction> update(@PathVariable String id, Principal principal, @RequestBody TransactionDTO dto) {
    String userId = principal.getName();
    Optional<Transaction> userTransaction = transactionService.findByIdAndUserId(id,userId);
if (userTransaction.isEmpty()){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
}
 Transaction updated = transactionService.update(id,userId,dto);
         return ResponseEntity.ok(updated);
}
}
