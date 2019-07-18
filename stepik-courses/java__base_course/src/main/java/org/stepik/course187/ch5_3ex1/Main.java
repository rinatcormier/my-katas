package org.stepik.course187.ch5_3ex1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class Main {
    static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder builder = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            builder.append((char) c);
        }
        return builder.toString();
    }
}
