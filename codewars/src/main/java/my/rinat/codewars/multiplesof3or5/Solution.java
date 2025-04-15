package my.rinat.codewars.multiplesof3or5;

public class Solution {

    public int solution(int number) {
        final int[] multiples = new int[number];
        for (int multiple = 3; multiple < multiples.length; multiple += 3) {
            multiples[multiple] = 1;
        }
        for (int multiple = 5; multiple < multiples.length; multiple += 5) {
            multiples[multiple] = 1;
        }
        int sum = 0;
        for (int i = 3; i < multiples.length; i++) {
            if (multiples[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
