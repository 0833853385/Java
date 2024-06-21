package com.example.btcn_thuchanhjava.Validator;

import com.example.btcn_thuchanhjava.entity.User;
import com.example.btcn_thuchanhjava.repository.IUserRepository;
import com.example.btcn_thuchanhjava.Validator.annotation.ValidUsername;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null || username.isBlank()) {
            return false; // Username cannot be null or blank
        }

        // Check if username already exists in the database
        User existingUser = userRepository.findByUsername(username);
        return existingUser == null; // Return true if username doesn't exist (valid)
    }
}
