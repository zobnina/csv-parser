package org.example.csvparser;

public class Starter {
    private static final String USER_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        String srcFile1 = USER_DIR + "/src/main/resources/srcFiles/1.csv";
        String outFile1 = USER_DIR + "/src/main/resources/outFiles/1.csv";
        CsvConfig config = new CsvConfig();
        CsvReader reader = new CsvReader(config);
        CsvData csvData = reader.read(srcFile1);
        config = new CsvConfig(FieldDelimiter.COMMA, TextDelimiter.SINGLE_QUOTE, true);
        CsvWriter writer = new CsvWriter(config);
        writer.write(csvData, outFile1);
    }
}
