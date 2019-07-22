package org.stepik.course187.ch6_2ex2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stepik.test.AbstractIOMocker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;

class MainTest extends AbstractIOMocker {

    @ParameterizedTest
    @MethodSource("candidates")
    void testMain(String input, String output) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mockIn(new ByteArrayInputStream(input.getBytes()));
        mockOut(out);
        Main.main(new String[] {});
        assertThat(out.toString()).isEqualTo(output);
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of("1 2 3 4 5 6 7", "6 4 2")
        );
    }
}