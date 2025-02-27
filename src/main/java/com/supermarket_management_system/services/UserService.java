package com.supermarket_management_system.services;



import com.supermarket_management_system.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // Method to save a user
    User saveUser(User user);

    // Method to get all users
    List<User> getAllUsers();

    // Method to get a user by ID
    Optional<User> getUserById(Long id);

    // Method to update user
    User updateUser(Long id, User user);

    // Method to delete user
    void deleteUser(Long id);
}


