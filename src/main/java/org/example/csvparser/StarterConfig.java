package org.example.csvparser;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class StarterConfig {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String PROPERTIES_PATH = USER_DIR + "/src/main/resources/work.properties";

    private String srcFile;
    private String outFile;
    private String srcDelimiterSymbol;
    private String outDelimiterSymbol;
    private String srcQuotationSymbol;
    private String outQuotationSymbol;
    private boolean srcHeaders;
    private boolean outHeaders;

    public StarterConfig() {
        File file = new File(PROPERTIES_PATH);
        try (FileReader reader = new FileReader(file)) {
            Properties properties = new Properties();
            properties.load(reader);
            srcFile = properties.getProperty("src.file");
            outFile = properties.getProperty("out.file");
            srcDelimiterSymbol = properties.getProperty("src.delimiter-symbol");
            outDelimiterSymbol = properties.getProperty("out.delimiter-symbol");
            srcQuotationSymbol = properties.getProperty("src.quotation-symbol");
            outQuotationSymbol = properties.getProperty("out.quotation-symbol");
            srcHeaders = Boolean.parseBoolean(properties.getProperty("src.headers"));
            outHeaders = Boolean.parseBoolean(properties.getProperty("out.headers"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSrcFile() {
        return srcFile;
    }

    public String getOutFile() {
        return outFile;
    }

    public DelimiterSymbol getSrcDelimiterSymbol() {
        return Enum.valueOf(DelimiterSymbol.class, srcDelimiterSymbol);
    }

    public DelimiterSymbol getOutDelimiterSymbol() {
        return Enum.valueOf(DelimiterSymbol.class, outDelimiterSymbol);
    }

    public QuotationSymbol getSrcQuotationSymbol() {
        return Enum.valueOf(QuotationSymbol.class, srcQuotationSymbol);
    }

    public QuotationSymbol getOutQuotationSymbol() {
        return Enum.valueOf(QuotationSymbol.class, outQuotationSymbol);
    }

    public boolean isSrcHeaders() {
        return srcHeaders;
    }

    public boolean isOutHeaders() {
        return outHeaders;
    }
}
