package org.stepik.course187.ch6_2ex1;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        HashSet<T> copyOfSet1 = new HashSet<>(set1);
        HashSet<T> copyOfSet2 = new HashSet<>(set2);

        copyOfSet1.removeAll(set2);
        copyOfSet2.removeAll(set1);

        HashSet<T> result = new HashSet<>();
        result.addAll(copyOfSet1);
        result.addAll(copyOfSet2);

        return result;
    }
}
