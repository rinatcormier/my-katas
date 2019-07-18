package org.stepik.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class AbstractIOMocker {

    private static final InputStream originalIn = System.in;
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    static void setUp() {
        mockOut(new ByteArrayOutputStream());
    }

    @AfterAll
    static void tearDown() {
        restoreIn();
        restoreOut();
    }

    protected static void mockIn(ByteArrayInputStream in) {
        System.setIn(in);
    }

    protected static void mockOut(ByteArrayOutputStream out) {
        System.setOut(new PrintStream(out));
    }

    private static void restoreIn() {
        if (System.in != originalIn) {
            System.setIn(originalIn);
        }
    }

    private static void restoreOut() {
        if (System.out != originalOut) {
            System.setOut(originalOut);
        }
    }
}
