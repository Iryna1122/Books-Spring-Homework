package com.test.BooksSpringHomework.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title = "";
    private String author = "";
    private String genre = "";
    private int year = 0;
    private int pageCount = 0;
    private String description = "";

    public Book() {
    }

    public Book(String title, String author, String genre, int year, int pageCount, String description) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.pageCount = pageCount;
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
//    Назва книги
//        ПІБ автора
//         Рік випуску
//         Жанр книги
//         Кількість сторінок
//         Короткий опис книги