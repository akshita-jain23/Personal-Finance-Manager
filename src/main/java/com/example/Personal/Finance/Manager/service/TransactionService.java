package com.example.Personal.Finance.Manager.service;

import com.example.Personal.Finance.Manager.dto.TransactionDTO;
import com.example.Personal.Finance.Manager.model.Transaction;
import com.example.Personal.Finance.Manager.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

public Transaction create(TransactionDTO dto , String userId) {
    Transaction transaction = mapDtoToEntity(userId, dto);
    return transactionRepository.save(transaction);
    }

    private Transaction mapDtoToEntity(String userId, TransactionDTO dto) {
        Transaction t =  new Transaction();
        t.setUserId(userId);
        t.setAmount(dto.getAmount());
        t.setCategory(dto.getCategory());
        t.setDate(dto.getDate());
        t.setType(dto.getType());
        t.setNotes(dto.getNotes());
        return t;
    }

    public Transaction update(String id,String userId, TransactionDTO dto) {
        Transaction existing = transactionRepository.findByIdAndUserId(id,userId)
                .orElseThrow(() -> new RuntimeException("Transaction not found or does not belong to user"));

        existing.setAmount(dto.getAmount());
        existing.setCategory(dto.getCategory());
        existing.setDate(dto.getDate());
        existing.setType(dto.getType());
        existing.setNotes(dto.getNotes());

        return transactionRepository.save(existing);
    }
    public List<Transaction>getByUserId(String userId) {
        return transactionRepository.findByUserId(userId);
    }
    public Optional<Transaction> findByIdAndUserId(String id, String userId) {
        return transactionRepository.findByIdAndUserId(id, userId);
    }
    public void delete(String id, String userId) {
        Transaction existing = transactionRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transactionRepository.delete(existing);
    }
}
