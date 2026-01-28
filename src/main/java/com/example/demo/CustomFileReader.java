package com.example.demo;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CustomFileReader {
    private static List<Map<String, String>> readJsonFile(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, new TypeReference<List<Map<String, String>>>() {});
    }

    private static List<Map<String, String>> readCsvFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        List<Map<String, String>> records = new ArrayList<>();
        if (!sc.hasNextLine()) return records;

        String[] headers = sc.nextLine().split(",");

        while (sc.hasNextLine()) {
            String row = sc.nextLine();
            String[] columns = row.split(",");
            Map<String, String> record = new HashMap<>();
            for (int i = 0; i < headers.length; i++)
                record.put(headers[i], columns[i]);
            records.add(record);
        }
        return records;
    }

    public static List<Map<String, String>> readFile(File file) throws FileNotFoundException {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        return switch (extension) {
            case ".json" -> readJsonFile(file);
            case ".csv" -> readCsvFile(file);
            default -> null;
        };
    }
}
