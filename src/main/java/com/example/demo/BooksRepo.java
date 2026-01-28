package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BooksRepo {
    private final List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void saveAll(List<Book> books) {
        this.books.addAll(books);
    }
}
