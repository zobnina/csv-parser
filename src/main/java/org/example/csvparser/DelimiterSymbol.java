package org.example.csvparser;

public enum DelimiterSymbol {

    COMMA(","),
    SEMICOLON(";"),
    TAB("\t"),
    PIPE("|");

    private final String delimiterSymbol;

    DelimiterSymbol(String symbol) {
        delimiterSymbol = symbol;
    }

    public String getValue() {
        return delimiterSymbol;
    }
}
