package org.stepik.course187.ch6_3ex1;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return (x) -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}
