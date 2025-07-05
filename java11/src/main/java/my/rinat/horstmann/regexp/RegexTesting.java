package my.rinat.horstmann.regexp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexTesting {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Enter pattern:");
        var patternString = in.nextLine();
        var pattern = Pattern.compile(patternString);
        while (true) {
            System.out.println("Enter string to match:");
            var input = in.nextLine();
            if (input == null || input.isEmpty()) {
                return;
            }
            var matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Match");
                var g = matcher.groupCount();
                if (g > 0) {
                    for (int i = 0; i < input.length(); i++) {
                        // Print any empty groups
                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i == matcher.end(j)) {
                                System.out.print("()");
                            }
                        }
                        // Print "(" for non-empty groups starting here
                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i != matcher.end(j)) {
                                System.out.print('(');
                            }
                        }
                        System.out.print(input.charAt(i));
                        // Print ")" for non-empty groups ending here
                        for (int j = 1; j <= g; j++) {
                            if (i + 1 != matcher.start(j) && i + 1 == matcher.end(j)) {
                                System.out.print(')');
                            }
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.println("No match");
            }
        }
    }
}
