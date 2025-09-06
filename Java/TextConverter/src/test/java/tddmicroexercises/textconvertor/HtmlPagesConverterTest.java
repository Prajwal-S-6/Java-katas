package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HtmlPagesConverterTest {

    HtmlTextConverter mockHtmlConverter;

    @BeforeEach
    void setUp() {
        mockHtmlConverter = mock(HtmlTextConverter.class);
    }

    @Test
    public void foo() throws IOException {
        HtmlPagesConverter pagesConverter = new HtmlPagesConverter("foo", mockHtmlConverter);
        assertEquals("foo", pagesConverter.getFilename());
    }

    @Test
    public

}
