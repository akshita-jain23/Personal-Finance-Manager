package com.example.Personal.Finance.Manager.service;

import com.example.Personal.Finance.Manager.dto.TransactionDTO;
import com.example.Personal.Finance.Manager.model.Transaction;
import com.example.Personal.Finance.Manager.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

    public Transaction create(TransactionDTO transactionDTO,String userId) {
        Transaction transaction = mapDtoToEntity(userId,transactionDTO);
        return transactionRepository.save(transaction);
    }

    private Transaction mapDtoToEntity(String userId, TransactionDTO transactionDTO) {
        Transaction t =  new Transaction();
        t.setUserId(userId);
        t.setAmount(transactionDTO.getAmount());
        t.setCategory(transactionDTO.getCategory());
        t.setDate(transactionDTO.getDate());
        t.setType(transactionDTO.getType());
        t.setNotes(transactionDTO.getNotes());
        return t;

    }
}
