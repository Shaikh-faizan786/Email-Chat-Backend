package com.emailchatapp.controller;

import com.emailchatapp.dto.LoginRequestDTO;
import com.emailchatapp.dto.UserDTO;
import com.emailchatapp.entity.User;
import com.emailchatapp.repository.UserRepository;
import com.emailchatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }


        @PostMapping("/login")
        public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO request) {
            Optional<User> userOptional = userRepository.findByUsername(request.getUsername());

            if (userOptional.isPresent()) {
                User user = userOptional.get();

                // Directly check password (Assuming it's stored as plain text, but not recommended)
                if (user.getPassword().equals(request.getPassword())) {
                    return ResponseEntity.ok("Login successful!");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


