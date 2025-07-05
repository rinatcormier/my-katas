package my.rinat.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public final class MockedStdIO {

    private static final InputStream ORIGINAL_IN = System.in;
    private static final PrintStream ORIGINAL_OUT = System.out;

    private final ByteArrayInputStream mockedIn;
    private final ByteArrayOutputStream mockedOut;

    public MockedStdIO(String input) {
        this.mockedIn = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        this.mockedOut = new ByteArrayOutputStream();
    }

    public void run(Consumer<ByteArrayOutputStream> code) {
        mockIO();
        code.accept(mockedOut);
        restoreIO();
    }

    private void mockIO() {
        System.setIn(mockedIn);
        System.setOut(new PrintStream(mockedOut));
    }

    private void restoreIO() {
        System.setIn(ORIGINAL_IN);
        System.setOut(ORIGINAL_OUT);
    }
}
