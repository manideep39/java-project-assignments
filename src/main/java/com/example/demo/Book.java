package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Book {
    private long book_id;
    private String title;
    private String author;
    private String genre;
    private BigDecimal price;
    private double rating;
}
