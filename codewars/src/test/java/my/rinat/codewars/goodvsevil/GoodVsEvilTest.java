package my.rinat.codewars.goodvsevil;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoodVsEvilTest {

    @Test
    public void testEvilWin() {
        assertThat(GoodVsEvil.battle("3328 239 6538 7425 5296 4502", "119 5668 472 2782 1162 5564 7025"))
                .isEqualTo("Battle Result: Evil eradicates all trace of Good");
    }

    @Test
    public void testGoodWin() {
        assertThat(GoodVsEvil.battle("0 0 0 0 0 10", "0 1 1 1 1 0 0"))
                .isEqualTo("Battle Result: Good triumphs over Evil");
    }

    @Test
    public void testTie() {
        assertThat(GoodVsEvil.battle("1 0 0 0 0 0", "1 0 0 0 0 0 0"))
                .isEqualTo("Battle Result: No victor on this battle field");
    }
}
