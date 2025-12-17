package greedy_algorithms.collecting_signatures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        var segments = new ArrayList<Segment>();
        for (int i = 0; i < n; i++) {
            segments.add(new Segment(scanner.nextInt(), scanner.nextInt()));
        }
        segments.sort(Comparator.comparingInt(segment -> segment.right));
        int crossesCount = 0;
        var crosses = new ArrayList<Integer>();
        while (!segments.isEmpty()) {
            var least = segments.remove(0);
            crossesCount++;
            crosses.add(least.right);
            segments.removeIf(least::isRightCrossed);
        }
        System.out.println(crossesCount);
        System.out.println(
                crosses.stream()
                        .map(cross -> Integer.toString(cross))
                        .collect(Collectors.joining(" "))
        );
    }

    private static class Segment {

        private final int left;
        private final int right;

        Segment(int left, int right) {
            this.left = left;
            this.right = right;
        }

        boolean isRightCrossed(Segment that) {
            return that.left <= this.right && that.right >= this.right;
        }
    }
}
