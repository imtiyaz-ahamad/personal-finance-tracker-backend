package com.immu.dao;

import com.immu.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert new user into the database
    public int saveUser(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword());
    }

    // Find user by email
    @SuppressWarnings("deprecation")
	public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }
    // New method to find user by ID
    @SuppressWarnings("deprecation")
    public User findById(int userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }
}
