package org.stepik.part1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stepik.common.BaseTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

class MainTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("candidates")
    void testMain(int a, int b, int sum) {
        try (ByteArrayInputStream in = new ByteArrayInputStream((a + " " + b).getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            mockIn(in);
            mockOut(out);
            Main.main(new String[] {});
            assertThat(out.toString()).isEqualTo(sum + System.getProperty("line.separator"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 3, 5),
                Arguments.of(5, 9, 14)
        );
    }
}