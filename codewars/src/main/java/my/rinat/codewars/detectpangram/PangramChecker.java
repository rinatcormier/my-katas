package my.rinat.codewars.detectpangram;

import java.util.HashMap;
import java.util.Map;

public class PangramChecker {

    public boolean check(String sentence) {
        var alphabet = alphabet();
        for (var letter : sentence.toCharArray()) {
            alphabet.replace(Character.toLowerCase(letter), true);
        }
        for (var value : alphabet.values()) {
            if (!value) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Boolean> alphabet() {
        return new HashMap<>() {{
            put('a', false);
            put('b', false);
            put('c', false);
            put('d', false);
            put('e', false);
            put('f', false);
            put('g', false);
            put('h', false);
            put('i', false);
            put('j', false);
            put('k', false);
            put('l', false);
            put('m', false);
            put('n', false);
            put('o', false);
            put('p', false);
            put('q', false);
            put('r', false);
            put('s', false);
            put('t', false);
            put('u', false);
            put('v', false);
            put('w', false);
            put('x', false);
            put('y', false);
            put('z', false);
        }};
    }
}