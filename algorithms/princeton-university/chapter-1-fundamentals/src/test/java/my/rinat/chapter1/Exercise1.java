package my.rinat.chapter1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.Test;

class Exercise1 {

    @Test
    void exercise_1_1_1() {
        // @formatter:off
        //noinspection PointlessArithmeticExpression
        assertThat((0 + 15) / 2)                 .isEqualTo(7);
        assertThat(2.0e-6 * 100_000_000.1)       .isEqualTo(200.000_000_2, offset(0.0));
        //noinspection PointlessBooleanExpression,ConstantConditions
        assertThat(true && false || true && true).isTrue();
        // @formatter:on
    }
}
