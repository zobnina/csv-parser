package org.example.csvparser;

public enum DelimiterSymbol {

    COMMA(","),
    SEMICOLON(";"),
    TAB("\t"),
    PIPE("|");

    private final String symbol;

    DelimiterSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getValue() {
        return symbol;
    }
}
