package org.example.csvparser;

public class CsvConfig {
    private final FieldDelimiter fieldDelimiter;
    private final TextDelimiter textDelimiter;
    private final boolean isHeaders;

    public CsvConfig() {
        fieldDelimiter = FieldDelimiter.COMMA;
        textDelimiter = TextDelimiter.DOUBLE_QUOTE;
        isHeaders = true;
    }

    public CsvConfig(FieldDelimiter delimiter, TextDelimiter frame, boolean isHeaders) {
        this.fieldDelimiter = delimiter;
        this.textDelimiter = frame;
        this.isHeaders = isHeaders;
    }

    public FieldDelimiter getFieldDelimiter() {
        return fieldDelimiter;
    }

    public TextDelimiter getTextDelimiter() {
        return textDelimiter;
    }

    public boolean isHeaders() {
        return isHeaders;
    }
}
