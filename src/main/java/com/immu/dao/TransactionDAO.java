package com.immu.dao;

import com.immu.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAO {
    private final JdbcTemplate jdbcTemplate;

    public TransactionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert a new transaction
    public int saveTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (user_id, type, category, amount, description, transaction_date) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, transaction.getUserId(), transaction.getType(), transaction.getCategory(),
                transaction.getAmount(), transaction.getDescription(), transaction.getTransactionDate());
    }

    // Get all transactions for a user
    @SuppressWarnings("deprecation")
	public List<Transaction> findByUserId(int userId) {
        String sql = "SELECT * FROM transactions WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            Transaction transaction = new Transaction();
            transaction.setId(rs.getInt("id"));
            transaction.setUserId(rs.getInt("user_id"));
            transaction.setType(rs.getString("type"));
            transaction.setCategory(rs.getString("category"));
            transaction.setAmount(rs.getBigDecimal("amount"));
            transaction.setDescription(rs.getString("description"));
            transaction.setTransactionDate(rs.getDate("transaction_date"));
            return transaction;
        });
    }
}
