package my.rinat.codewars.convertstringtocamelcase;

class Solution {

    static String toCamelCase(String string) {
        String[] words = string.split("[-_]");
        if (words.length == 1) {
            return words[0];
        }
        StringBuilder inCamelCase = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            inCamelCase.append(capitalize(words[i]));
        }
        return inCamelCase.toString();
    }

    static String capitalize(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }
}