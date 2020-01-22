package my.rinat.course1547.ch1_1ex1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stepik.test.AbstractIOMocker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends AbstractIOMocker {

    @ParameterizedTest
    @MethodSource("candidates")
    void testMain(String str, String res) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            mockIn(in);
            mockOut(out);
            Main.main(new String[]{});
            assertThat(out.toString()).isEqualTo(res + System.getProperty("line.separator"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of("{", "1"),
                Arguments.of("{[]", "1"),
                Arguments.of("{{{", "3"),
                Arguments.of("[]([]", "3"),
                Arguments.of("{{{[][][]", "3"),
                Arguments.of("{{{{{{{((()))}", "6"),
                Arguments.of("{()}{", "5"),
                Arguments.of("}()", "1"),
                Arguments.of("()}()", "3"),
                Arguments.of("}()", "1"),
                Arguments.of("{[()]}}()", "7"),
                Arguments.of("dasdsadsadas]]]", "13")
        );
    }
}