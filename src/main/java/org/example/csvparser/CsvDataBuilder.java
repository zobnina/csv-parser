package org.example.csvparser;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvDataBuilder {
    private final CsvConfig config;

    public CsvDataBuilder(CsvConfig config) {
        this.config = config;
    }

    public CsvData createData(Map<Integer, LinkedHashMap<Integer, String>> data) {
        CsvData file = new CsvData();
        file.setHeaders(prepareHeaders(data));
        file.setData(prepareData(data));
        return file;
    }

    private Map<Integer, LinkedHashMap<Integer, String>> prepareData(Map<Integer, LinkedHashMap<Integer, String>> data) {
        if (!config.isHeaders()) return data;
        return data.entrySet().stream()
                .filter(x -> x.getKey() != 0)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new));
    }

    private Map<Integer, String> prepareHeaders(Map<Integer, LinkedHashMap<Integer, String>> data) {
        if (config.isHeaders()) return data.get(0);
        Map<Integer, String> headerRow = new LinkedHashMap<>();
        if (data.get(0) != null) {
            for (Map.Entry<Integer, String> firstRowField : data.get(0).entrySet()) {
                Integer columnIndex = firstRowField.getKey();
                headerRow.put(columnIndex, "COLUMN_" + columnIndex);
            }
        }
        return headerRow;
    }
}
