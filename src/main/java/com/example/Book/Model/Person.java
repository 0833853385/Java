package com.example.Book.Model;

import java.time.LocalDate;
import java.util.List;

public class Person {
    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public Person(String name, Integer age, boolean isMarried, Integer sex, LocalDate createTime, List<String> language) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
        this.sex = sex;
        this.createTime = createTime;
        this.language = language;
    }

    private String name;
    private Integer age;
    private Integer sex;
    private boolean isMarried;
    private LocalDate createTime;
    private List<String> language;
}
