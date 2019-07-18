package org.stepik.course217.ch2_3ex1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stepik.test.AbstractIOMocker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

class MainTest extends AbstractIOMocker {

    @ParameterizedTest
    @MethodSource("candidates")
    void testMain(int a, int b, int result) {
        try (ByteArrayInputStream in = new ByteArrayInputStream((a + " " + b).getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            mockIn(in);
            mockOut(out);
            Main.main(new String[] {});
            assertThat(out.toString()).isEqualTo(result + System.getProperty("line.separator"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(18, 35, 1),
                Arguments.of(14159572, 63967072, 4)
        );
    }
}