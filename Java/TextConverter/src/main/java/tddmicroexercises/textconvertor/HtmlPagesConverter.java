package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlPagesConverter {

    private String filename;
    private Converter converter;

    public HtmlPagesConverter(String filename, Converter converter) throws IOException {
        this.filename = filename;
        this.converter = converter;
    }

    private List<Integer> getPageBreaks() throws IOException {
        List<Integer> breaks = new ArrayList<>();
        breaks.add(0);
        BufferedReader reader = (BufferedReader) converter.getReader();
        int cumulativeCharCount = 0;
        String line = reader.readLine();
        while (line != null)
        {
            cumulativeCharCount += line.length() + 1; // add one for the newline
            if (line.contains("PAGE_BREAK")) {
                int page_break_position = cumulativeCharCount;
                breaks.add(page_break_position);
            }
            line = reader.readLine();
        }
        reader.close();
        return breaks;
    }

    public String getHtmlPage(int page) throws IOException {
       int pagesToSkip = getPageBreaks().get(page);
       return converter.convert(pagesToSkip);
    }

    public String getFilename() {
        return this.filename;
    }
    
}
