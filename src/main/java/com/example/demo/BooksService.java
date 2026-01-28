package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BooksService {
    private final BooksRepo booksRepo;

    public BooksService(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    public void bulkImport(String folderPath) throws IOException {
        File inputFile = new File(folderPath);
        if (inputFile.isDirectory()) {
            File[] files = inputFile.listFiles();
            if (files == null)
                throw new IOException();
            for (File file: files) {
                List<Map<String, String>> records = CustomFileReader.readFile(file);
                if (records == null) continue;
                List<Book> books = new ArrayList<>();
                records.forEach(record -> {
                    books.add(BookMapper.booksFileRowToBook(record));
                });
                booksRepo.saveAll(books);
            }
        }
    }
}
