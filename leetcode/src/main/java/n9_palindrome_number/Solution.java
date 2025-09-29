package n9_palindrome_number;

public class Solution {

    public boolean isPalindrome(int x) {
        var original = new StringBuilder(String.valueOf(x));
        var reversed = new StringBuilder(String.valueOf(x)).reverse();
        return original.compareTo(reversed) == 0;
    }
}