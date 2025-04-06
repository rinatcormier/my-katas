package my.rinat.codewars.goodvsevil;

import java.util.stream.IntStream;

public class GoodVsEvil {

    private static final int[] goodWorth = new int[]{1, 2, 3, 3, 4, 10};
    private static final int[] evilWorth = new int[]{1, 2, 2, 2, 3, 5, 10};

    public static String battle(String goodAmounts, String evilAmounts) {
        final var goodCounts = goodAmounts.split(" ");
        final var goodWorthSum = IntStream.range(0, goodCounts.length)
                .map(index -> Integer.parseInt(goodCounts[index]) * goodWorth[index])
                .reduce(Integer::sum)
                .orElse(0);
        final var evilCounts = evilAmounts.split(" ");
        final var evilWorthSum = IntStream.range(0, evilCounts.length)
                .map(index -> Integer.parseInt(evilCounts[index]) * evilWorth[index])
                .reduce(Integer::sum)
                .orElse(0);
        if (goodWorthSum == evilWorthSum) {
            return "Battle Result: No victor on this battle field";
        }
        return goodWorthSum > evilWorthSum
                ? "Battle Result: Good triumphs over Evil"
                : "Battle Result: Evil eradicates all trace of Good";
    }
}
