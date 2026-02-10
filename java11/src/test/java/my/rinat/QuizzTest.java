package my.rinat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class QuizzTest {

    @Test
    void test() {
        List<String> list = Arrays.asList("a", "bb", "ccc", "dddd");
        long count = list.stream()
                .peek(s -> System.out.print(s + "-"))
                .filter(s -> s.length() > 2)
                .limit(1)
                .count();
        System.out.println(count);
    }
}
