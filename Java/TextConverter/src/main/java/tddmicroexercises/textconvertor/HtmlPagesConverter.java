package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class HtmlPagesConverter {

    private final String filename;
    private final BufferedReader reader;


    public HtmlPagesConverter(String filename, Reader reader) {
        this.filename = filename;
        this.reader = (BufferedReader) reader;
    }

    public String getHtmlPage() throws IOException {
       return convert();
    }

    public String getFilename() {
        return this.filename;
    }

    public String convert() throws IOException {

        String line = reader.readLine();
        StringBuilder htmlPage = new StringBuilder();
        while (line != null)
        {
            if (line.contains("PAGE_BREAK")) {
                break;
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(line));
            htmlPage.append("<br />");

            line = reader.readLine();
        }
        reader.close();
        return htmlPage.toString();
    }
    
}
