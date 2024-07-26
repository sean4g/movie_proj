package com.MovieWatcher.controllers;

import com.MovieWatcher.model.User;
import com.MovieWatcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    //register to database
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) { 
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    //get information about user {username}
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }
}
