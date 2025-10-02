package n14_longest_common_prefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        final var longestPrefix = new StringBuilder();
        final var firstStr = strs[0];
        boolean isCompleted = false;
        for (int i = 0; i < firstStr.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i + 1 > strs[j].length()) {
                    isCompleted = true;
                    break;
                }
                if (strs[j].charAt(i) != firstStr.charAt(i)) {
                    isCompleted = true;
                    break;
                }
            }
            if (isCompleted) {
                break;
            } else {
                longestPrefix.append(firstStr.charAt(i));
            }
        }
        return longestPrefix.toString();
    }
}
