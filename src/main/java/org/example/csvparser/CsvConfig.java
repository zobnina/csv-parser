package org.example.csvparser;

public class CsvConfig {
    private final DelimiterSymbol delimiterSymbol;
    private final QuotationSymbol quotationSymbol;
    private final boolean isHeaders;

    public CsvConfig() {
        delimiterSymbol = DelimiterSymbol.COMMA;
        quotationSymbol = QuotationSymbol.DOUBLE_QUOTE;
        isHeaders = true;
    }

    public CsvConfig(DelimiterSymbol delimiter, QuotationSymbol frame, boolean isHeaders) {
        this.delimiterSymbol = delimiter;
        this.quotationSymbol = frame;
        this.isHeaders = isHeaders;
    }

    public DelimiterSymbol getFieldDelimiter() {
        return delimiterSymbol;
    }

    public QuotationSymbol getQuotationSymbol() {
        return quotationSymbol;
    }

    public boolean isHeaders() {
        return isHeaders;
    }
}
