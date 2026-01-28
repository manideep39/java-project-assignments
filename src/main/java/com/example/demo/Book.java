package com.example.demo;

import java.math.BigDecimal;

public class Book {
    private long book_id;
    private String title;
    private String author;
    private String genre;
    private BigDecimal price;
    private double rating;

    public Book(long book_id, String title, String author, String genre, BigDecimal price, double rating) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
