package org.example.csvparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CsvReader {
    private final CsvConfig config;
    private final CsvDataBuilder csvDataBuilder;
    private final CsvFieldHelper fieldHelper;

    public CsvReader(CsvConfig config) {
        this.config = config;
        csvDataBuilder = new CsvDataBuilder(config);
        fieldHelper = new CsvFieldHelper(config);
    }

    public CsvData read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<Integer, LinkedHashMap<Integer, String>> fileData = new LinkedHashMap<>();
            int rowIndex = 0;
            String row;
            while ((row = reader.readLine()) != null) {
                LinkedHashMap<Integer, String> rowMap = this.readRow(row);
                fileData.put(rowIndex, rowMap);
                rowIndex++;
            }
            return csvDataBuilder.createData(fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private LinkedHashMap<Integer, String> readRow(String row) {
        String textDelimiter = config.getTextDelimiter().getValue();
        String fieldDelimiter = config.getFieldDelimiter().getValue();
        StringBuilder fieldBuilder = new StringBuilder();
        String[] delimiterSplitArray = row.split(config.getFieldDelimiter().getValue());
        LinkedHashMap<Integer, String> fieldsValues = new LinkedHashMap<>();
        int columnIndex = 0;
        boolean isBuilding = false;
        for (String segment : delimiterSplitArray) {
            if (segment.startsWith(textDelimiter) && !segment.endsWith(textDelimiter)) {
                fieldBuilder.setLength(0);
                fieldBuilder.append(segment).append(fieldDelimiter);
                isBuilding = true;
            } else if (isBuilding && segment.endsWith(textDelimiter)) {
                fieldBuilder.append(segment);
                String fieldValue = fieldHelper.removeRedundantTextDelimiters(fieldBuilder.toString());
                fieldsValues.put(columnIndex, fieldValue);
                columnIndex++;
                isBuilding = false;
            } else if (!isBuilding) {
                fieldBuilder.setLength(0);
                fieldBuilder.append(segment);
                String fieldValue = fieldHelper.removeRedundantTextDelimiters(fieldBuilder.toString());
                fieldsValues.put(columnIndex, fieldValue);
                columnIndex++;
            } else {
                fieldBuilder.append(segment);
            }
        }
        return fieldsValues;
    }
}
