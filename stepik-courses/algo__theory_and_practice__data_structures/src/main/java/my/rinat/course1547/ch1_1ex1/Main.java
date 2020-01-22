package my.rinat.course1547.ch1_1ex1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            if (!in.hasNext()) {
                System.out.println("Success");
                return;
            }
            int index = indexOfInvalidParenthesis(in.next());
            System.out.println(index == -1 ? "Success" : "" + index);
        }
    }

    private static int indexOfInvalidParenthesis(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Integer> position = new ArrayDeque<>();
        char[] charArray = str.toCharArray();
        int i;
        for (i = 0; i < charArray.length; i++) {
            char current = charArray[i];
            if (isOpenParenthesis(current)) {
                stack.push(current);
                position.push(i + 1);
            } else {
                if (isParenthesis(current)) {
                    char open;
                    try {
                        open = stack.pop();
                        position.pop();
                    } catch (NoSuchElementException ex) {
                        return i + 1;
                    }
                    if ((open == '(' && current != ')')
                            || (open == '[' && current != ']')
                            || (open == '{' && current != '}')) {
                        return i + 1;
                    }
                }
            }
        }
        return stack.isEmpty() ? -1 : position.pop();
    }

    private static boolean isOpenParenthesis(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isParenthesis(char ch) {
        return ch == '(' || ch == '[' || ch == '{'
                || ch == ')' || ch == ']' || ch == '}';
    }
}