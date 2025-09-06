package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HtmlPagesConverterTest {

    HtmlTextConverter mockHtmlConverter;
    HtmlPagesConverter pagesConverter;

    @BeforeEach
    void setUp() {
        mockHtmlConverter = mock(HtmlTextConverter.class);
        pagesConverter = new HtmlPagesConverter("foo", mockHtmlConverter);
    }

    @Test
    public void foo() {
        assertEquals("foo", pagesConverter.getFilename());
    }

    @Test
    public void shouldReturnEmptyStringWhenPageisEmpty() throws IOException {
        when(mockHtmlConverter.convert(0)).thenReturn("");
        when(mockHtmlConverter.getReader()).thenReturn(mock(BufferedReader.class));

        assertEquals("", pagesConverter.getHtmlPage(0));
        verify(mockHtmlConverter, times(1)).convert(0);

    }

}
