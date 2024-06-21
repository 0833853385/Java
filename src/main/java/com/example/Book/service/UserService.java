package com.example.Book.service;

import com.example.Book.entity.User;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    void save(User user);
}
