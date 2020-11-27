package org.example.csvparser;

public enum TextDelimiter {

    DOUBLE_QUOTE("\""),
    SINGLE_QUOTE("'"),
    BACKQUOTE("`"),
    BACKSLASH("\\");

    private final String frameSymbol;

    TextDelimiter(String symbol) {
        frameSymbol = symbol;
    }

    public String getValue() {
        return frameSymbol;
    }
}
