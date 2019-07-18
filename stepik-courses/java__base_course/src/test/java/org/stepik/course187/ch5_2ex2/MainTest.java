package org.stepik.course187.ch5_2ex2;

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
    void testMain(byte[] bytesIn, byte[] bytesOut) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mockIn(new ByteArrayInputStream(bytesIn));
        mockOut(out);
        Main.main(new String[] {});
        assertThat(out.toByteArray()).containsExactly(bytesOut);
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(new byte[] {65, 13, 10, 10, 13}, new byte[] {65, 10, 10, 13}),
                Arguments.of(new byte[] {}, new byte[] {}),
                Arguments.of(new byte[] {1, 2, 3}, new byte[] {1, 2, 3}),
                Arguments.of(new byte[] {13, 10, 1, 2, 3, 4, 5, 6}, new byte[] {10, 1, 2, 3, 4, 5, 6}),
                Arguments.of(new byte[] {1, 2, 3, 13, 10, 4, 5, 6}, new byte[] {1, 2, 3, 10, 4, 5, 6}),
                Arguments.of(new byte[] {1, 2, 3, 4, 5, 6, 13, 10}, new byte[] {1, 2, 3, 4, 5, 6, 10}),
                Arguments.of(new byte[] {1, 2, 3, 13, 13, 10, 4, 5, 6}, new byte[] {1, 2, 3, 13, 10, 4, 5, 6}),
                Arguments.of(new byte[] {1, 2, 3, 10, 13, 4, 5, 6}, new byte[] {1, 2, 3, 10, 13, 4, 5, 6}),
                Arguments.of(new byte[] {1, 2, 3, 13, 10, 13, 10, 4, 5, 6}, new byte[] {1, 2, 3, 10, 10, 4, 5, 6}),
                Arguments.of(new byte[] {1, 2, 13, 10, 3, 4, 13, 10, 5, 6}, new byte[] {1, 2, 10, 3, 4, 10, 5, 6}),
                Arguments.of(new byte[] {65, 13, 10, 10, 13}, new byte[] {65, 10, 10, 13}),
                Arguments.of(new byte[] {65, 66, 13, 13, 10, 10, 13, 67, 13, 13}, new byte[] {65, 66, 13, 10, 10, 13, 67, 13, 13})
        );
    }
}