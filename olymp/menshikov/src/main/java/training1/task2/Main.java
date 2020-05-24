package training1.task2;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.ToIntBiFunction;

/**
 * <a href="https://acmp.ru/asp/do/index.asp?main=task&id_course=5&id_section=29&id_topic=137&id_problem=854">Задача</a>
 */
public class Main {
    public static void main(String[] args) {
        new Shell().execute((reader, writer) -> new Program(reader, writer).run());
    }
}

class Shell {
    void execute(BiConsumer<Scanner, PrintWriter> code) {
        try (var scanner = new Scanner(System.in); var writer = new PrintWriter(System.out)) {
            code.accept(scanner, writer);
        }
    }
}

class Program {

    private final Scanner reader;
    private final PrintWriter writer;

    Program(Scanner reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    void run() {
        var inputs = new Inputs(reader);
        new Expression(inputs.getOperands(), inputs.getOperators(), inputs.getExpected())
                .solution()
                .ifPresentOrElse(writer::println, () -> writer.println("No solution"));
    }

    private static class Inputs {

        private final int expected;
        private final int[] operands;
        private final char[] operators;

        public Inputs(Scanner reader) {
            int quantity = reader.nextInt();
            this.expected = reader.nextInt();
            this.operands = new int[quantity];
            for (int i = 0; i < operands.length; i++) {
                operands[i] = reader.nextInt();
            }
            this.operators = new char[quantity];
            Arrays.fill(operators, '-');
        }

        public int getExpected() {
            return expected;
        }

        public int[] getOperands() {
            int[] copy = new int[operands.length];
            System.arraycopy(operands, 0, copy, 0, operands.length);
            return copy;
        }

        public char[] getOperators() {
            char[] copy = new char[operators.length];
            System.arraycopy(this.operators, 0, copy, 0, operators.length);
            return copy;
        }
    }
}

class Expression {

    private final static Map<Character, ToIntBiFunction<Integer, Integer>> PLAIN_CALCULATIONS = Map.ofEntries(
            Map.entry('+', Integer::sum),
            Map.entry('-', (operand1, operand2) -> operand1 - operand2)
    );

    private final int[] operands;
    private final char[] operators;
    private final int expected;

    public Expression(int[] operands, char[] operators, int expected) {
        this.operands = operands;
        this.operators = operators;
        this.expected = expected;
    }

    public Optional<String> solution() {
        var defaultResult = compute();
        if (hasSolution(defaultResult)) {
            return Optional.of(expression());
        } else {
            return Optional.empty();
        }
    }

    private int compute() {
        int sum = operands[0];
        for (int i = 1; i < operators.length; i++) {
            sum = PLAIN_CALCULATIONS.get(operators[i]).applyAsInt(sum, operands[i]);
        }
        return sum;
    }

    private boolean hasSolution(int current) {
        boolean hasSolution = (current == expected);
        while (operators[0] != '+' && !hasSolution) {
            int index = operators.length - 1;
            boolean minusFound = false;
            while (!minusFound && operators[index] == '-') {
                operators[index] = '+';
                minusFound = true;
                current += (2 * operands[index--]);
                hasSolution = (current == expected);
            }
            if (!minusFound) {
                while (operators[index] == '+') {
                    operators[index] = '-';
                    current -= (2 * operands[index--]);
                }
                operators[index] = '+';
                current += (2 * operands[index]);
                hasSolution = (current == expected);
            }
        }
        return hasSolution;
    }

    private String expression() {
        StringBuilder builder = new StringBuilder(String.valueOf(operands[0]));
        for (int i = 1; i < operands.length; i++) {
            builder.append(operators[i]).append(operands[i]);
        }
        builder.append("=").append(expected);
        return builder.toString();
    }
}
