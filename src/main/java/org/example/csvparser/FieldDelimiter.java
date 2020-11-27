package org.example.csvparser;

public enum FieldDelimiter {

    COMMA(","),
    SEMICOLON(";"),
    TAB("\t"),
    PIPE("|");

    private final String delimiterSymbol;

    FieldDelimiter(String symbol) {
        delimiterSymbol = symbol;
    }

    public String getValue() {
        return delimiterSymbol;
    }
}
