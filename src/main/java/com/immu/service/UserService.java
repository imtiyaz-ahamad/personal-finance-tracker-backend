package com.immu.service;

import com.immu.dao.UserDAO;
import com.immu.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Register a new user
    public int registerUser(User user) {
        return userDAO.saveUser(user);
    }

    // Find user by email
    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }
 // New method to fetch user by userId
    public User getUserById(int userId) {
        return userDAO.findById(userId);  // You would need to implement this method in UserDAO
    }
}
