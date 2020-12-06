package org.example.csvparser;

public enum QuotationSymbol {

    DOUBLE_QUOTE("\""),
    SINGLE_QUOTE("'"),
    BACKQUOTE("`"),
    BACKSLASH("\\");

    private final String frameSymbol;

    QuotationSymbol(String symbol) {
        frameSymbol = symbol;
    }

    public String getValue() {
        return frameSymbol;
    }
}
