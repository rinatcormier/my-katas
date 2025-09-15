package util;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public final class Utils {

    private Utils() {
    }

    public static String separatedObjectsAsString(Object... objects) {
        return Stream.of(objects)
                .map(String::valueOf)
                .collect(joining(System.lineSeparator(), "", System.lineSeparator()));
    }
}
