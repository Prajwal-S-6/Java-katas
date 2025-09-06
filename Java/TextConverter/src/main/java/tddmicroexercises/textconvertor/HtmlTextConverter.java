package tddmicroexercises.textconvertor;

import java.io.*;

public class HtmlTextConverter implements Converter
{

	BufferedReader reader;

    public HtmlTextConverter(Reader reader)
    {
		this.reader = (BufferedReader) reader;
    }


	@Override
	public Reader getReader() throws FileNotFoundException {
		return reader;
	}

	@Override
	public String convert(int page) throws IOException {
		reader.skip(page);
		StringBuffer htmlPage = new StringBuffer();
		String line = reader.readLine();
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
