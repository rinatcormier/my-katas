package my.rinat.codewars.codewarsstylerankingsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    private void do_test(User user, int rank, int expectedRank, int expectedProgress) {
        if (rank != 0) user.incProgress(rank);
        assertThat(user.rank)
                .isEqualTo(expectedRank);
        assertThat(user.progress)
                .isEqualTo(expectedProgress);
    }

    @Test
    public void testIncProgress() throws Exception {
        var user = new User();
        do_test(user, -8, -8, 3);

        user = new User();
        do_test(user, -7, -8, 10);

        user = new User();
        do_test(user, -6, -8, 40);

        user = new User();
        do_test(user, -5, -8, 90);

        user = new User();
        do_test(user, -4, -7, 60);

        user = new User();
        do_test(user, -8, -8, 3);

        user = new User();
        do_test(user, 1, -2, 40);
        do_test(user, 1, -2, 80);
        do_test(user, 1, -1, 20);
        do_test(user, 1, -1, 30);
        do_test(user, 1, -1, 40);
        do_test(user, 2, -1, 80);
        do_test(user, 2, 1, 20);
        do_test(user, -1, 1, 21);
    }

    @Test
    public void throwsExceptionWhenPassedZero() {
        assertThatThrownBy(() -> new User().incProgress(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void throwsExceptionWhenPassedLessThanMinumumRank() {
        assertThatThrownBy(() -> new User().incProgress(-9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void throwsExceptionWhenPassedGreaterThanMaximumRank() {
        assertThatThrownBy(() -> new User().incProgress(9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("paramsWhenUserHasTheSameRank")
    public void incrementsProgress(int initProgress, int initRank, int passedRank,
                                   int expectedProgress, int expectedRank) {
        final var user = new User();
        user.progress = initProgress;
        user.rank = initRank;
        user.incProgress(passedRank);
        assertThat(user.progress)
                .isEqualTo(expectedProgress);
        assertThat(user.rank)
                .isEqualTo(expectedRank);
    }

    private static Stream<Arguments> paramsWhenUserHasTheSameRank() {
        return Stream.of(
                Arguments.of(0, -8, -8, 3, -8),
                Arguments.of(99, -8, -8, 2, -7),
                Arguments.of(99, -7, -8, 0, -6),
                Arguments.of(99, -6, -8, 99, -6),
                Arguments.of(97, -1, -1, 0, 1),
                Arguments.of(50, -6, -4, 90, -6),
                Arguments.of(95, -6, -4, 35, -5),
                Arguments.of(0, -8, -1, 90, -4),
                Arguments.of(0, -8, 1, 40, -2),
                Arguments.of(0, -8, 8, 0, 8),
                Arguments.of(0, 8, 8, 0, 8),
                Arguments.of(90, 7, 8, 0, 8)
        );
    }
}
