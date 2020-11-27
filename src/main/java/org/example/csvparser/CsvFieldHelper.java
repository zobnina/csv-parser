package org.example.csvparser;

class CsvFieldHelper {
    private final CsvConfig config;

    public CsvFieldHelper(CsvConfig config) {
        this.config = config;
    }

    public String removeRedundantTextDelimiters(String value) {
        String textDelimiter = config.getTextDelimiter().getValue();
        if (value.startsWith(textDelimiter) && value.endsWith(textDelimiter)) {
            value = value.substring(1, value.length() - 1);
        }
        value = value.replaceAll(textDelimiter + textDelimiter, textDelimiter);
        return value;
    }

    public String addTextDelimiters(String value) {
        String fieldDelimiter = config.getFieldDelimiter().getValue();
        String textDelimiter = config.getTextDelimiter().getValue();

        if (value.contains(textDelimiter)) {
            value = value.replaceAll(textDelimiter, textDelimiter + textDelimiter);
        }

        StringBuilder builder = new StringBuilder();
        if (value.contains(fieldDelimiter) || value.contains(textDelimiter)) {
            builder.append(textDelimiter);
            builder.append(value);
            builder.append(textDelimiter);
            value = builder.toString();
        }

        return value;
    }
}
