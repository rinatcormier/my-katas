package org.stepik.part2;

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
    void testMain(int n, long result) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(String.valueOf(n).getBytes());
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
                Arguments.of(0, 0L),
                Arguments.of(1, 1L),
                Arguments.of(2, 1L),
                Arguments.of(3, 2L),
                Arguments.of(4, 3L),
                Arguments.of(5, 5L),
                Arguments.of(6, 8L)
        );
    }
}