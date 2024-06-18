package com.example.Book.controller;

import com.example.Book.Model.Person;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class PersonController {
    @GetMapping("/person")
    public String index(Model model)
    {
        model.addAttribute("title","Demo Thymeleaf");
        model.addAttribute("info","<b>Thông tin </b></br>");
        Person p = new Person();
        p.setName("Thymeleaf Spring Boot");
        p.setAge(36);
        p.setSex(1);
        p.setMarried(true);
        p.setCreateTime(LocalDate.now());
        p.setLanguage(Arrays.asList("Java","C#","Python"));
                model.addAttribute("person", p);
        return "person";
    }

    @GetMapping("/person/register")
    public String register()
    {
        return "register";
    }
    @PostMapping("/person/register")
    public String register(Model model, @ModelAttribute Person person)
    {
        model.addAttribute("person",person);
        return "thankyou";
    }
}

