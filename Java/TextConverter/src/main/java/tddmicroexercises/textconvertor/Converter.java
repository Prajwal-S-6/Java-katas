package tddmicroexercises.textconvertor;

import java.io.*;

public interface Converter {

    Reader getReader() throws FileNotFoundException;
    String convert(int page) throws IOException;
}
