package my.rinat.codewars.mumbling;

public class Accumul {

    public static String accum(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder result = new StringBuilder(accum(charArray[0], 0));
        for (int i = 1; i < charArray.length; i++) {
            result.append("-").append(accum(charArray[i], i));
        }
        return result.toString();
    }

    private static String accum(char letter, int repeat) {
        char[] result = new char[repeat + 1];
        result[0] = Character.toUpperCase(letter);
        char lower = Character.toLowerCase(letter);
        for (int i = 1; i < result.length; i++) {
            result[i] = lower;
        }
        return new String(result);
    }
}