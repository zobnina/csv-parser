package org.example.csvparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CsvWriter {
    private final CsvConfig config;
    private final CsvFieldHelper fieldHelper;

    public CsvWriter(CsvConfig config) {
        this.config = config;
        fieldHelper = new CsvFieldHelper(config);
    }

    public void write(CsvData csvData, String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                if (config.isHeaders()) writeHeaders(writer, csvData);
                writeData(writer, csvData);
            }
        } catch (IOException e) {

        }
    }

    private void writeData(BufferedWriter writer, CsvData csvData) throws IOException {
        Map<Integer, LinkedHashMap<Integer, String>> data = csvData.getData();
        for (Map.Entry<Integer, LinkedHashMap<Integer, String>> row : data.entrySet()) {
            LinkedHashMap<Integer, String> rowData = row.getValue();
            writeRow(writer, rowData);
        }
    }

    private void writeRow(BufferedWriter writer, Map<Integer, String> rowData) throws IOException {
        for (Map.Entry<Integer, String> field : rowData.entrySet()) {
            Integer columnIndex = field.getKey();
            String delimiter = config.getFieldDelimiter().getValue();
            if (columnIndex.equals(rowData.size() - 1)) {
                delimiter = "\n";
            }
            String columnValue = fieldHelper.addTextDelimiters(field.getValue());
            writer.write(columnValue + delimiter);
        }
    }

    private void writeHeaders(BufferedWriter writer, CsvData csvData) throws IOException {
        Map<Integer, String> headers = csvData.getHeaders();
        writeRow(writer, headers);
    }
}
