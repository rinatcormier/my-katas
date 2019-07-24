package org.stepik.course187.ch6_4ex3;

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
                Arguments.of("Мама мыла-мыла-мыла раму!", String.format("мыла%nмама%nраму%n")),
                Arguments.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.",
                        String.format("consectetur%nfaucibus%nipsum%nlorem%nadipiscing%namet%ndolor%neget%nelit%nmi%n"))
        );
    }
}