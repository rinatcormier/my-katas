package ch__1_2__1;

import common.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

class MainTest extends BaseTest {
    @Test
    void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mockOut(out);
        Main.main(new String[] {});
        Assertions.assertEquals("It's alive! It's alive!\r\n", out.toString());
    }
}
