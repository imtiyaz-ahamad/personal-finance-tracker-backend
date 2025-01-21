package com.immu.controller;

import com.immu.model.Transaction;
import com.immu.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add")
    public String addTransaction(@RequestBody Transaction transaction) {
        int result = transactionService.addTransaction(transaction);
        return result > 0 ? "Transaction added successfully!" : "Transaction failed!";
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getUserTransactions(@PathVariable int userId) {
        return transactionService.getTransactionsByUser(userId);
    }
}
