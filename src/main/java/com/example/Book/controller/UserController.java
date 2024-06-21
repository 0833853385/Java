package com.example.Book.controller;


import com.example.Book.entity.User;

import com.example.Book.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, @RequestParam("confirmPassword") String confirmPassword) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                model.addAttribute(error.getField() + "_error", error.getDefaultMessage());
            }
            return "user/register";
        }

        // Kiểm tra xem tên người dùng đã tồn tại chưa
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("username_error", "Username already exists");
            return "user/register";
        }

        // Kiểm tra xem email đã tồn tại chưa
        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("email_error", "Email already exists");
            return "user/register";
        }

        // Kiểm tra xác nhận mật khẩu
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("confirmPassword_error", "Passwords do not match");
            return "user/register";
        }

        // Mã hóa mật khẩu trước khi lưu
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        try {
            // Lưu người dùng vào cơ sở dữ liệu
            userService.save(user);
        } catch (Exception e) {
            model.addAttribute("save_error", "Error saving user. Please try again.");
            return "user/register";
        }

        return "redirect:/login";
    }
}
