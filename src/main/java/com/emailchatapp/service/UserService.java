package com.emailchatapp.service;

import com.emailchatapp.entity.User;

import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    Optional<User> findUserByUsername(String username);
}