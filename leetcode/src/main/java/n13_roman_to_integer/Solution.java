package n13_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<String, Integer> romanToInt = new HashMap<>();
    {
        romanToInt.put("I" , 1);
        romanToInt.put("IV", 4);
        romanToInt.put("V" , 5);
        romanToInt.put("IX", 9);
        romanToInt.put("X" , 10);
        romanToInt.put("XL", 40);
        romanToInt.put("L" , 50);
        romanToInt.put("XC", 90);
        romanToInt.put("C" , 100);
        romanToInt.put("CD", 400);
        romanToInt.put("D" , 500);
        romanToInt.put("CM", 900);
        romanToInt.put("M" , 1000);
    }

    public int romanToInt(String str) {
        int idx = 0;
        int res = 0;
        while(idx < str.length()){
            if (idx + 1 < str.length() && romanToInt.containsKey(str.substring(idx, idx + 2))) {
                res += romanToInt.get(str.substring(idx, idx + 2));
                idx += 2;
            } else {
                res += romanToInt.get(str.substring(idx, idx + 1));
                idx += 1;
            }
        }
        return res;
    }
}
