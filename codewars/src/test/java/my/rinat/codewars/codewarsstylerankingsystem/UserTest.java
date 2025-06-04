package my.rinat.codewars.codewarsstylerankingsystem;

import org.junit.jupiter.api.Test;

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
    public void throwsExceptionWhenPassedLessThanNegativeEight() {
        assertThatThrownBy(() -> new User().incProgress(-9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void throwsExceptionWhenPassedGreaterThanEight() {
        assertThatThrownBy(() -> new User().incProgress(9))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
