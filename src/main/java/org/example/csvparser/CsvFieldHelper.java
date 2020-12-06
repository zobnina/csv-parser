package org.example.csvparser;

class CsvFieldHelper {
    private final CsvConfig config;

    public CsvFieldHelper(CsvConfig config) {
        this.config = config;
    }

    public String removeRedundantQuotationSymbols(String value) {
        String quotationSymbol = config.getQuotationSymbol().getValue();
        if (value.startsWith(quotationSymbol) && value.endsWith(quotationSymbol)) {
            value = value.substring(1, value.length() - 1);
        }
        value = value.replaceAll(quotationSymbol + quotationSymbol, quotationSymbol);
        return value;
    }

    public String addQuotationSymbols(String value) {
        String delimiterSymbol = config.getFieldDelimiter().getValue();
        String quotationSymbol = config.getQuotationSymbol().getValue();

        if (value.contains(quotationSymbol)) {
            value = value.replaceAll(quotationSymbol, quotationSymbol + quotationSymbol);
        }

        StringBuilder builder = new StringBuilder();
        if (value.contains(delimiterSymbol) || value.contains(quotationSymbol)) {
            builder.append(quotationSymbol);
            builder.append(value);
            builder.append(quotationSymbol);
            value = builder.toString();
        }

        return value;
    }
}
