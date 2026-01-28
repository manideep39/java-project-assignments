package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private final BooksRepo booksRepo;
    private final BooksService booksService;

    public DemoApplication(BooksRepo booksRepo, BooksService booksService) {
        this.booksRepo = booksRepo;
        this.booksService = booksService;
    }

	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws IOException {
        booksService.bulkImport("src/main/java/com/example/demo/books");
        booksRepo.getBooks().forEach(System.out::println);
    }
}
