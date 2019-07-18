package org.stepik.course187.ch5_3ex1;

import static java.nio.charset.StandardCharsets.US_ASCII;
import static org.assertj.core.api.Assertions.assertThat;
import static org.stepik.course187.ch5_3ex1.Main.readAsString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

class MainTest {

    @ParameterizedTest
    @MethodSource("candidates")
    void testReadAsString(byte[] bytes, String result) throws IOException {
        assertThat(readAsString(new ByteArrayInputStream(bytes), US_ASCII)).isEqualTo(result);
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(new byte[] {48, 49, 50, 51}, "0123")
        );
    }
}