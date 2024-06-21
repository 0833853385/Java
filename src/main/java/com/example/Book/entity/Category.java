package com.example.Book.entity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    // Constructor, getters, and setters
    // Lombok đã sinh ra các getter và setter cho name, books

    // Getter và Setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Thêm phương thức để thêm sách vào danh sách books
    public void addBook(Book book) {
        books.add(book);
        book.setCategory(this); // Thiết lập mối quan hệ ngược từ Book đến Category
    }

    // Thêm phương thức để xóa sách khỏi danh sách books
    public void removeBook(Book book) {
        books.remove(book);
        book.setCategory(null); // Xóa mối quan hệ ngược từ Book đến Category
    }
}

