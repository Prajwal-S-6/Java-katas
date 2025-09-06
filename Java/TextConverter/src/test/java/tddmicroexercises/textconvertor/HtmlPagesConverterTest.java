package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.io.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HtmlPagesConverterTest {

    BufferedReader mockReader;
    HtmlPagesConverter pagesConverter;

    @BeforeEach
    void setUp() {
        mockReader = mock(BufferedReader.class);
        pagesConverter = new HtmlPagesConverter("foo", mockReader);
    }

    @Test
    public void foo() {
        assertEquals("foo", pagesConverter.getFilename());
    }

    @Test
    public void shouldReturnEmptyStringWhenPageIsEmpty() throws IOException {
        when(mockReader.readLine()).thenReturn(null);

        assertEquals("", pagesConverter.getHtmlPage());

    }

    @Test
    public void shouldReturnHtmlConvertedString() throws IOException {
        when(mockReader.readLine()).thenReturn("line1").thenReturn("line2").thenReturn(null);

        String htmlPage = pagesConverter.getHtmlPage();

        String expectedString = "line1<br />line2<br />";
        assertEquals(expectedString, htmlPage);
    }

    @Test
    public void shouldReturnHtmlConvertedStringAfterEscapingCharacters() throws IOException {
        when(mockReader.readLine()).thenReturn("line1", "line2&", null);

        String htmlPage = pagesConverter.getHtmlPage();

        String expectedString = "line1<br />line2&amp;<br />";
        assertEquals(expectedString, htmlPage);
    }

    @Test
    public void shouldReturnHtmlConvertedStringBeforePageBreak() throws IOException {
        when(mockReader.readLine()).thenReturn("'line1'", "line2&", "<line3>", "PAGE_BREAK", "line4", null);

        String htmlPage = pagesConverter.getHtmlPage();

        String expectedString = "&quot;line1&quot;<br />line2&amp;<br />&lt;line3&gt;<br />";
        assertEquals(expectedString, htmlPage);
    }




}
