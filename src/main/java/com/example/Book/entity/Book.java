package com.example.Book.entity;

import com.example.Book.Validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "Tiêu đề không được để trống")
    @Size(max = 50, min = 1, message = "Tiêu đề phải từ 1 đến 50 ký tự")
    private String title;

    @Column(name = "author")
    @NotEmpty(message = "Tác giả không được để trống")
    private String author;

    @Column(name = "price")
    @NotNull(message = "Giá tiền không được để trống")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ValidUserId
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // Constructor, getters, and setters
    // Lombok đã sinh ra các getter và setter cho title, author, price, user

    // Getter và Setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và Setter cho category
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}