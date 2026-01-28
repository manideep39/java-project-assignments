package com.example.demo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class BookMapper {
    public static Book booksFileRowToBook(Map<String, String> record) {
        return new Book(
                Long.parseLong(record.get("book_id")),
                record.get("title"),
                record.get("author"),
                record.get("genre"),
                new BigDecimal(record.get("price")),
                Double.parseDouble(record.get("rating"))
        );
    }
}
