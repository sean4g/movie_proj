package com.MovieWatcher.service;

import com.MovieWatcher.model.User;
import com.MovieWatcher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean authenticateUser(String username, String passwordHash) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPasswordHash().equals(passwordHash);
    }
}
