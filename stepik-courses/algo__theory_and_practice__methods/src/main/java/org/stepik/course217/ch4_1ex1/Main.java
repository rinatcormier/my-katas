package org.stepik.course217.ch4_1ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int segmentsCount = in.nextInt();
            final List<Segment> segments = new ArrayList<>();
            for (int i = 0; i < segmentsCount; i++) {
                segments.add(new Segment(in.nextInt(), in.nextInt()));
            }
            segments.sort(Comparator.comparingInt(Segment::getB));
            List<Integer> points = new ArrayList<>();
            while (!segments.isEmpty()) {
                Segment firstSegment = segments.remove(0);
                if (firstSegment == null) {
                    continue;
                }
                points.add(firstSegment.getB());
                segments.removeIf(segment -> firstSegment.getB() >= segment.getA());
            }
            System.out.println(points.size());
            System.out.print(points.get(0));
            for (int i = 1; i < points.size(); i++) {
                System.out.print(" " + points.get(i));
            }
            System.out.println();
        }
    }

    private static class Segment {

        private final int a;
        private final int b;

        public Segment(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
