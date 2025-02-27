package com.supermarket_management_system.services;



import com.supermarket_management_system.entities.User;
import com.supermarket_management_system.repositories.UserRepository;
import com.supermarket_management_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);  // Save the user to the database
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();  // Return all users from the database
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);  // Find a user by ID
    }

    @Override
    public User updateUser(Long id, User user) {
        // Check if the user exists, then update
        if (userRepository.existsById(id)) {
            user.setId(id);  // Set the ID to ensure the correct user is updated
            return userRepository.save(user);
        }
        return null;  // If the user doesn't exist, return null (you can handle this better)
    }

    @Override
    public void deleteUser(Long id) {
        // Delete the user by ID
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
