package org.example.csvparser;

import java.util.LinkedHashMap;
import java.util.Map;

public class CsvData {
    private Map<Integer, String> headers;
    private Map<Integer, LinkedHashMap<Integer, String>> data;

    public CsvData() {
        headers = new LinkedHashMap<>();
        data = new LinkedHashMap<>();
    }

    public Map<Integer, String> getHeaders() {
        return headers;
    }

    public Map<Integer, LinkedHashMap<Integer, String>> getData() {
        return data;
    }

    public void setHeaders(Map<Integer, String> headers) {
        this.headers = headers;
    }

    public void setData(Map<Integer, LinkedHashMap<Integer, String>> data) {
        this.data = data;
    }
}
