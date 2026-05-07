package com.alvaro.financebot.service;

import com.alvaro.financebot.entity.Transaction;
import com.alvaro.financebot.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction save(Transaction transaction) {
        transaction.setCreatedAt(LocalDateTime.now());
        return repository.save(transaction);
    }
    public Double getTotalByCategoryThisMonth(String category) {
        Double total = repository.sumByCategoryThisMonth(category);
        return total != null ? total : 0.0;
    }
}
