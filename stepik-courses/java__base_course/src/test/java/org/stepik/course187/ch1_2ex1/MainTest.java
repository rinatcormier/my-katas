package org.stepik.course187.ch1_2ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.stepik.test.AbstractIOMocker;

import java.io.ByteArrayOutputStream;

class MainTest extends AbstractIOMocker {
    @Test
    void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mockOut(out);
        Main.main(new String[] {});
        final String lineSeparator = System.getProperty("line.separator");
        Assertions.assertEquals("It's alive! It's alive!" + lineSeparator, out.toString());
    }
}
