package com.example.Personal.Finance.Manager.service;

import com.example.Personal.Finance.Manager.dto.TransactionDto;
import com.example.Personal.Finance.Manager.exception.CustomException;
import com.example.Personal.Finance.Manager.model.Transaction;
import com.example.Personal.Finance.Manager.repository.TransactionRepository;
import com.example.Personal.Finance.Manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    public Transaction createTransaction(String userId, TransactionDto dto) {
        if (userRepository.existsById(userId)) {
            Transaction transaction = new Transaction();
            transaction.updateFromDto(dto);
            transaction.setUserId(userId);
            transaction.setDate(ZonedDateTime.now());
            return transactionRepository.save(transaction);
        }else  {
            throw new CustomException.UserNotFoundException(userId);
        }
    }

    public  List<Transaction> getAllTransaction(String userId) {
        if (!userRepository.existsById(userId)){
            throw new CustomException.UserNotFoundException(userId);
        }
        return transactionRepository.findByUserId(userId);
    }


    public Transaction updateTransactionById(String userId, String transactionId, TransactionDto dto) {
        if (!userRepository.existsById(userId)) {
            throw new CustomException.UserNotFoundException(userId);
        }
        Transaction transaction = transactionRepository
                .findById(transactionId)
                .orElseThrow(() ->
                        new CustomException.TransactionNotFoundException(transactionId)
                );
        transaction.updateFromDto(dto);
        transaction.setUserId(userId);
        transaction.setDate(ZonedDateTime.now());
        return transactionRepository.save(transaction);
    }

    public ResponseEntity<Transaction> deleteTransactionById(String userId, String transactionId) {
        if (!userRepository.existsById(userId)) {
            throw new CustomException.UserNotFoundException(userId);
        }
        Transaction transaction = transactionRepository
                .findById(transactionId)
                .orElseThrow(() ->
                        new CustomException.TransactionNotFoundException(transactionId)
                );
        transactionRepository.delete(transaction);
        return ResponseEntity.ok(transaction);
    }
}
