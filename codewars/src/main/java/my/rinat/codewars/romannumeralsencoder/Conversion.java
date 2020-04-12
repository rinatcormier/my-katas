package my.rinat.codewars.romannumeralsencoder;

import java.util.Map;

public class Conversion {

    public String solution(int n) {
        return RomanThousand.fromArabic(n).toString()
                + RomanHundred.fromArabic(n).toString()
                + RomanDecade.fromArabic(n).toString()
                + RomanUnit.fromArabic(n).toString();
    }

    private static class RomanUnit {

        Map<Integer, String> romans = Map.of(
                0, "",
                1, "I",
                2, "II",
                3, "III",
                4, "IV",
                5, "V",
                6, "VI",
                7, "VII",
                8, "VIII",
                9, "IX"
        );

        private final int arabicNumber;

        private RomanUnit(int arabicNumber) {
            this.arabicNumber = arabicNumber;
        }

        public static RomanUnit fromArabic(int number) {
            return new RomanUnit(number);
        }

        private int extractUnit() {
            return this.arabicNumber % 10;
        }

        @Override
        public String toString() {
            return romans.get(extractUnit());
        }
    }

    private static class RomanDecade {

        Map<Integer, String> romans = Map.of(
                0, "",
                10, "X",
                20, "XX",
                30, "XXX",
                40, "XL",
                50, "L",
                60, "LX",
                70, "LXX",
                80, "LXXX",
                90, "XC"
        );

        private final int arabicNumber;

        private RomanDecade(int arabicNumber) {
            this.arabicNumber = arabicNumber;
        }

        public static RomanDecade fromArabic(int number) {
            return new RomanDecade(number);
        }

        private int extractDecade() {
            return (this.arabicNumber % 100) - (this.arabicNumber % 10);
        }

        @Override
        public String toString() {
            return romans.get(extractDecade());
        }
    }

    private static class RomanHundred {

        Map<Integer, String> romans = Map.of(
                0, "",
                100, "C",
                200, "CC",
                300, "CCC",
                400, "CD",
                500, "D",
                600, "DC",
                700, "DCC",
                800, "DCCC",
                900, "CM"
        );

        private final int arabicNumber;

        private RomanHundred(int arabicNumber) {
            this.arabicNumber = arabicNumber;
        }

        public static RomanHundred fromArabic(int number) {
            return new RomanHundred(number);
        }

        private int extractHundred() {
            return (this.arabicNumber % 1000) - (this.arabicNumber % 100);
        }

        @Override
        public String toString() {
            return romans.get(extractHundred());
        }
    }

    private static class RomanThousand {

        Map<Integer, String> romans = Map.of(
                0, "",
                1000, "M",
                2000, "MM",
                3000, "MMM"
        );

        private final int arabicNumber;

        private RomanThousand(int arabicNumber) {
            this.arabicNumber = arabicNumber;
        }

        public static RomanThousand fromArabic(int number) {
            return new RomanThousand(number);
        }

        private int extractThousand() {
            return (this.arabicNumber % 10000) - (this.arabicNumber % 1000);
        }

        @Override
        public String toString() {
            return romans.get(extractThousand());
        }
    }
}