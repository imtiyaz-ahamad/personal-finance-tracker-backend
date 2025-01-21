package com.immu.service;

import com.immu.dao.TransactionDAO;
import com.immu.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionDAO transactionDAO;

    public TransactionService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    // Add a new transaction
    public int addTransaction(Transaction transaction) {
        return transactionDAO.saveTransaction(transaction);
    }

    // Get all transactions for a user
    public List<Transaction> getTransactionsByUser(int userId) {
        return transactionDAO.findByUserId(userId);
    }
}
