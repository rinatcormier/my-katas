package n20_valid_parentheses;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<Character, Character> bracketPairs = new HashMap<>();
    {
        bracketPairs.put('(', ')');
        bracketPairs.put('{', '}');
        bracketPairs.put('[', ']');
    }

    public boolean isValid(String string) {
        final var brackets = new ArrayDeque<Character>();
        boolean isValid = true;
        for (char currentBracket : string.toCharArray()) {
            if (bracketPairs.containsKey(currentBracket)) {
                brackets.push(currentBracket);
                continue;
            }
            if (brackets.isEmpty() && !bracketPairs.containsKey(currentBracket)) {
                isValid = false;
                break;
            }
            if (!brackets.isEmpty()) {
                var bracket = brackets.pop();
                var pair = bracketPairs.get(bracket);
                if (currentBracket != pair) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid && brackets.isEmpty();
    }
}
