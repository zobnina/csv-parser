package org.example.csvparser;

public class Starter {

    public static void main(String[] args) {
        StarterConfig starterConfig = new StarterConfig();
        CsvConfig readerConfig = new CsvConfig(
                starterConfig.getSrcDelimiterSymbol(),
                starterConfig.getSrcQuotationSymbol(),
                starterConfig.isSrcHeaders());
        CsvReader reader = new CsvReader(readerConfig);
        CsvData csvData = reader.read(starterConfig.getSrcFile());
        CsvConfig writerConfig = new CsvConfig(
                starterConfig.getOutDelimiterSymbol(),
                starterConfig.getOutQuotationSymbol(),
                starterConfig.isOutHeaders()
        );
        CsvWriter writer = new CsvWriter(writerConfig);
        writer.write(csvData, starterConfig.getOutFile());
    }
}
