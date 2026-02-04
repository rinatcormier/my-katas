package my.rinat;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

public class ThenComparingTest {

    private static class User {

        private final String name;
        private final String surname;

        public User(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(name, user.name)
                    && Objects.equals(surname, user.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname);
        }
    }

    @Test
    void thenComparingTest() {
        var a = new User("Aa", "Aac");
        var b = new User("Bb", "Aac");
        var c = new User("Cc", "Acc");
        var sortedByTwoFields = Stream.of(a, b, c)
                .sorted(comparing(User::getSurname).reversed().thenComparing(User::getName))
                .collect(Collectors.toList());
        assertThat(sortedByTwoFields)
                .containsExactly(c, a, b);
    }
}
